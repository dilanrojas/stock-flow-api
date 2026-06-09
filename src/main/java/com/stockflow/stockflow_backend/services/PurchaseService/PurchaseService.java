package com.stockflow.stockflow_backend.services.PurchaseService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseRequestDTO;
import com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs.PurchaseDetailRequestDTO;
import com.stockflow.stockflow_backend.entities.Purchase;
import com.stockflow.stockflow_backend.entities.PurchaseDetail;
import com.stockflow.stockflow_backend.entities.Stock;
import com.stockflow.stockflow_backend.exceptions.PurchaseNotFoundException;
import com.stockflow.stockflow_backend.exceptions.StockNotFoundException;
import com.stockflow.stockflow_backend.repositories.PurchaseRepository;
import com.stockflow.stockflow_backend.repositories.StockRepository;

@Service
public class PurchaseService implements IPurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private StockRepository stockRepository;


    private static final int PAGE_SIZE = 10;

    @Override
    public Page<Purchase> getAll(int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        
        Page<Purchase> purchases = purchaseRepository.findAll(pageable);
        purchases.forEach(purchase -> {
            calculatePurchaseProductsAmount(purchase);
            calculatePurchaseTotal(purchase);
        });

    

        return purchases;
    }

    @Override
    public Purchase addPurchase(PurchaseRequestDTO purchaseRequestDTO) {

        Purchase purchase = Purchase.builder()
        .date(purchaseRequestDTO.getDate())
        .reason(purchaseRequestDTO.getReason())
        .resourceId(UUID.randomUUID())
        .purchaseDetails(new ArrayList<>())
        .build();


        for (PurchaseDetailRequestDTO purchaseDetailDTO : purchaseRequestDTO.getPurchaseDetails()) {

            Stock stock = stockRepository.findByResourceId(purchaseDetailDTO.getStockResourceId()).orElseThrow(() -> new StockNotFoundException());
            Integer newQuantity = stock.getQuantity() + purchaseDetailDTO.getQuantity();
            stock.setQuantity(newQuantity); 


            PurchaseDetail purchaseDetail = PurchaseDetail.builder()
            .purchase(purchase)
            .stock(stock)
            .quantity(purchaseDetailDTO.getQuantity())
            .unitPrice(stock.getProduct().getPrice())
            .resourceId(UUID.randomUUID())
            .build();

            purchase.getPurchaseDetails().add(purchaseDetail);
        }


        calculatePurchaseTotal(purchase);
        calculatePurchaseProductsAmount(purchase);
        purchase.getPurchaseDetails().forEach(purchaseDetail -> calculateDetailSubTotal(purchaseDetail));

        return purchaseRepository.addPurchase(purchase);
        
    }

    @Override
    public Purchase getByResourceId(UUID resourceId) {
        Purchase purchase =  purchaseRepository.findByResourceId(resourceId)
            .orElseThrow(() -> new PurchaseNotFoundException(resourceId));


        calculatePurchaseProductsAmount(purchase);
        calculatePurchaseTotal(purchase);
        purchase.getPurchaseDetails().forEach(purchaseDetail -> calculateDetailSubTotal(purchaseDetail));
        
        
        return purchase;
    }





    private void calculatePurchaseProductsAmount(Purchase purchase) {

        Integer productsAmount = purchase.getPurchaseDetails().stream()
                                .mapToInt(purchaseDetail -> purchaseDetail.getQuantity())
                                .sum();

        purchase.setTotalProductsAmount(productsAmount);                        
        
    }



    private void calculatePurchaseTotal(Purchase purchase) {
        BigDecimal purchaseTotal = purchase.getPurchaseDetails().stream()
                                    .map(purchaseDetail -> purchaseDetail.getUnitPrice().multiply(BigDecimal.valueOf(purchaseDetail.getQuantity())))
                                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    


        purchase.setPurchaseTotal(purchaseTotal);
    }


    private void calculateDetailSubTotal(PurchaseDetail purchaseDetail){
        BigDecimal purchaseSubTotal = purchaseDetail.getUnitPrice().multiply(BigDecimal.valueOf(purchaseDetail.getQuantity()));
        purchaseDetail.setSubtotal(purchaseSubTotal);

    }


 
}
