package com.example.stockflowapi.facade;

import java.util.List;
import java.util.UUID;

import com.example.stockflowapi.dtos.ProductDto;
import com.example.stockflowapi.dtos.ProductRequestDto;

public interface IProductFacade {
  List<ProductDto> getAll();  
  ProductDto addProduct(ProductRequestDto productDto);
  ProductDto getByResourceId(UUID resourceId);
  ProductDto updateProduct(UUID resourceId, ProductRequestDto productDto);
  void removeProduct(UUID resourceId);
}
