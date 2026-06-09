package com.stockflow.stockflow_backend.services.StockService;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.stockflow.stockflow_backend.entities.Stock;

public interface IStockService {

    Page<Stock> getAll(int page);
    Stock findByResourceId(UUID resourceId);

}
