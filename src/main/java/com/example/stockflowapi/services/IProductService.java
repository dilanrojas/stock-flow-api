package com.example.stockflowapi.services;

import java.util.List;
import java.util.UUID;

import com.example.stockflowapi.dtos.ProductRequestDto;
import com.example.stockflowapi.entities.Product;

public interface IProductService {
  List<Product> getAll();  
  Product addProduct(ProductRequestDto product);
  Product getByResourceId(UUID resourceId);
  Product updateProduct(UUID resourceId, ProductRequestDto productDto);
  void removeProduct(UUID resourceId);
}
