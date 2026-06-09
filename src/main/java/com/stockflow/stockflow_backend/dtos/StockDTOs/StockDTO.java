package com.stockflow.stockflow_backend.dtos.StockDTOs;

import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.ProductDTOs.ProductDTO;

public record StockDTO(Integer quantity, Integer minimumQuantity, UUID resourceId, ProductDTO productDTO) {

}
