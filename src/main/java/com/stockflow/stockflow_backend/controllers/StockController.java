package com.stockflow.stockflow_backend.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.stockflow_backend.dtos.StockDTOs.StockDTO;
import com.stockflow.stockflow_backend.facade.StockFacade.IStockFacade;
import com.stockflow.stockflow_backend.mappers.StockMapper;
import com.stockflow.stockflow_backend.models.StockModels.StockResponseModel;

@RestController
@CrossOrigin("*")
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private IStockFacade stockFacade;

    @Autowired
    private StockMapper stockMapper;


    @GetMapping
    public ResponseEntity<Page<StockResponseModel>> getAll(@RequestParam(defaultValue = "0") int page){
        Page<StockDTO> stockDtoPage = stockFacade.getAll(page);

        return ResponseEntity.ok(stockMapper.toStockResponseModelPage(stockDtoPage));
    }

    @GetMapping(path = "/{resourceId}")
    public ResponseEntity<StockResponseModel> findByResourceId(@PathVariable("resourceId") UUID resourceId){
        return ResponseEntity.ok(stockMapper.toStockResponseModel(stockFacade.findByResourceId(resourceId)));
    }
    
}
