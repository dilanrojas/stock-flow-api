package com.example.stockflowapi.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockflowapi.dtos.ProductRequestDto;
import com.example.stockflowapi.entities.Product;
import com.example.stockflowapi.exceptions.ProductNotFoundException;
import com.example.stockflowapi.repositories.ProductRepository;

@Service
public class ProductService implements IProductService {
  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<Product> getAll() {
    return productRepository.getAll();
  }

  @Override
  public Product addProduct(ProductRequestDto productDto) {
    var product = Product
      .builder()
      .name(productDto.getName())
      .description(productDto.getDescription())
      .price(productDto.getPrice())
      .resourceId(UUID.randomUUID())
      .build();
    return productRepository.addProduct(product);
  }

  @Override
  public Product getByResourceId(UUID resourceId) {
    return productRepository.findByResourceId(resourceId)
      .orElseThrow(() -> new ProductNotFoundException("Producto no encontrado"));
  }

  @Override
  public Product updateProduct(UUID resourceId, ProductRequestDto productDto) {
    var product = productRepository.findByResourceId(resourceId).orElseThrow(() -> new RuntimeException("Product not found"));
    product.setName(productDto.getName());
    product.setDescription(productDto.getDescription());
    product.setPrice(productDto.getPrice());
    return productRepository.updateProduct(product);
  }

  @Override
  public void removeProduct(UUID resourceId) {
    var product = productRepository.findByResourceId(resourceId).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    productRepository.delete(product);
  }
}
