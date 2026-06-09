package com.stockflow.stockflow_backend.facade.StockFacade;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.StockDTOs.StockDTO;
import com.stockflow.stockflow_backend.entities.Stock;
import com.stockflow.stockflow_backend.mappers.StockMapper;
import com.stockflow.stockflow_backend.services.StockService.IStockService;


@Component
public class StockFacade implements IStockFacade{

    @Autowired
    private IStockService stockService;

    @Autowired
    private StockMapper stockMapper;

    @Override
    public Page<StockDTO> getAll(int page) {
        Page<Stock> stockPage = stockService.getAll(page);

        return stockMapper.toStockDTOPage(stockPage);
    }

    @Override
    public StockDTO findByResourceId(UUID resourceId) {
        return stockMapper.toStockDTO(stockService.findByResourceId(resourceId));
    }
    
}
