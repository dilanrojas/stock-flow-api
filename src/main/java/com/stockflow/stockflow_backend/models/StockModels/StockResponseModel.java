package com.stockflow.stockflow_backend.models.StockModels;

import java.util.UUID;

import com.stockflow.stockflow_backend.models.ProductModels.ProductResponseModel;

public record StockResponseModel(Integer quantity, Integer minimumQuantity, UUID resourceId, ProductResponseModel productResponseModel){
    
}
