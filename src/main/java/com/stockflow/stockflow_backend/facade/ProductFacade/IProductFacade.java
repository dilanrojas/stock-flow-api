package com.stockflow.stockflow_backend.facade.ProductFacade;

import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.ProductDTOs.ProductDTO;
import com.stockflow.stockflow_backend.dtos.ProductDTOs.ProductRequestDTO;

public interface IProductFacade {
  List<ProductDTO> getAll();  
  ProductDTO addProduct(ProductRequestDTO productDto);
  ProductDTO getByResourceId(UUID resourceId);
  ProductDTO updateProduct(UUID resourceId, ProductRequestDTO productDto);
  void removeProduct(UUID resourceId);
}
