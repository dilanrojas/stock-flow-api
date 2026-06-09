package com.stockflow.stockflow_backend.facade.ProductFacade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.ProductDTOs.ProductDTO;
import com.stockflow.stockflow_backend.dtos.ProductDTOs.ProductRequestDTO;
import com.stockflow.stockflow_backend.entities.Category;
import com.stockflow.stockflow_backend.entities.Product;
import com.stockflow.stockflow_backend.mappers.ProductMapper;
import com.stockflow.stockflow_backend.services.CategoryService.ICategoryService;
import com.stockflow.stockflow_backend.services.ProductService.IProductService;

import jakarta.transaction.Transactional;

@Component
public class ProductFacade implements IProductFacade {
 @Autowired
  private IProductService productService;

  @Autowired
  private ICategoryService categoryService;
  
  @Autowired
  private ProductMapper productMapper;



  @Override
  public List<ProductDTO> getAll() {
    return productMapper.toProductDtoList(productService.getAll());
  }

  @Override
  @Transactional
  public ProductDTO addProduct(ProductRequestDTO productDto) {
    Category category = categoryService.getByResourceId(productDto.getCategoryResourceId());
    Product product = productService.addProduct(productDto, category);
    return productMapper.toProductDto(product);
  }

  @Override
  public ProductDTO getByResourceId(UUID resourceId) {
    Product entity = productService.getByResourceId(resourceId);
    return productMapper.toProductDto(entity);
  }

  @Override
  @Transactional
  public ProductDTO updateProduct(UUID resourceId, ProductRequestDTO productDto) {
    Category category = categoryService.getByResourceId(productDto.getCategoryResourceId());
    Product entity = productService.updateProduct(resourceId, productDto, category);
    return productMapper.toProductDto(entity);
  }

  @Override
  @Transactional
  public void removeProduct(UUID resourceId) {
    productService.removeProduct(resourceId);
  }
}
