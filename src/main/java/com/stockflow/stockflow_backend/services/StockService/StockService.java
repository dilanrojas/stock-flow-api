package com.stockflow.stockflow_backend.services.StockService;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stockflow.stockflow_backend.entities.Stock;
import com.stockflow.stockflow_backend.exceptions.StockNotFoundException;
import com.stockflow.stockflow_backend.repositories.StockRepository;

@Service
public class StockService implements IStockService {

    @Autowired
    private StockRepository stockRepository;
    

    private static final int PAGE_SIZE = 5;

    @Override
    public Page<Stock> getAll(int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);

        return stockRepository.findAll(pageable);
    }

    @Override
    public Stock findByResourceId(UUID resourceId) {
        return stockRepository.findByResourceId(resourceId).orElseThrow(() -> new StockNotFoundException(resourceId));
    }




}
