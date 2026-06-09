package com.stockflow.stockflow_backend.facade.PurchaseFacade;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseDTO;
import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseRequestDTO;
import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseSummaryDTO;
import com.stockflow.stockflow_backend.entities.Purchase;
import com.stockflow.stockflow_backend.mappers.PurchaseMapper;
import com.stockflow.stockflow_backend.services.PurchaseService.IPurchaseService;

import jakarta.transaction.Transactional;

@Component
public class PurchaseFacade implements IPurchaseFacade {
    @Autowired
    private IPurchaseService purchaseService;

    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public Page<PurchaseSummaryDTO> getAll(int page) {
        return purchaseMapper.toPurchaseSummaryDTOPage(purchaseService.getAll(page));
    }

    @Override
    @Transactional
    public PurchaseDTO addPurchase(PurchaseRequestDTO dto) {
        Purchase purchase = purchaseService.addPurchase(dto);
        return purchaseMapper.toPurchaseDTO(purchase);
    }

    @Override
    public PurchaseDTO getByResourceId(UUID resourceId) {
        Purchase purchase = purchaseService.getByResourceId(resourceId);
        return purchaseMapper.toPurchaseDTO(purchase);
    }

   
}
