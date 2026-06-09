package com.stockflow.stockflow_backend.services.ProductService;

import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.ProductDTOs.ProductRequestDTO;
import com.stockflow.stockflow_backend.entities.Category;
import com.stockflow.stockflow_backend.entities.Product;

public interface IProductService {
  List<Product> getAll();  
  Product addProduct(ProductRequestDTO product, Category category);
  Product getByResourceId(UUID resourceId);
  Product updateProduct(UUID resourceId, ProductRequestDTO productDto, Category category);
  void removeProduct(UUID resourceId);
}
