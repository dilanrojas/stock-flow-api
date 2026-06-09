package com.stockflow.stockflow_backend.services.ProductService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockflow.stockflow_backend.dtos.ProductDTOs.ProductRequestDTO;
import com.stockflow.stockflow_backend.entities.Category;
import com.stockflow.stockflow_backend.entities.Product;
import com.stockflow.stockflow_backend.entities.Stock;
import com.stockflow.stockflow_backend.exceptions.ProductNotFoundException;
import com.stockflow.stockflow_backend.repositories.ProductRepository;

@Service
public class ProductService implements IProductService {
  @Autowired
  private ProductRepository productRepository;
  
  private static final int DEFUALT_QUANTITY = 0;

  @Override
  public List<Product> getAll() {
    return productRepository.getAll();
  }

  @Override
  public Product addProduct(ProductRequestDTO productRequestDTO, Category category) {

    Product product = Product
      .builder()
      .name(productRequestDTO.getName())
      .description(productRequestDTO.getDescription())
      .price(productRequestDTO.getPrice())
      .resourceId(UUID.randomUUID())
      .category(category)
      .imageURL(productRequestDTO.getImageURL())
      .build();


    Stock stock = Stock.builder()
      .product(product)
      .quantity(DEFUALT_QUANTITY)
      .minimumQuantity(productRequestDTO.getMinimumQuantity())
      .resourceId(UUID.randomUUID())
      .build();

    product.setStock(stock);
    return productRepository.save(product);
  }


  @Override
  public Product updateProduct(UUID resourceId, ProductRequestDTO productRequestDTO, Category category) {

    Product product = productRepository.findByResourceId(resourceId).orElseThrow(() -> new ProductNotFoundException());
    product.setName(productRequestDTO.getName());
    product.setDescription(productRequestDTO.getDescription());
    product.setPrice(productRequestDTO.getPrice());
    product.setCategory(category);
    product.setImageURL(productRequestDTO.getImageURL());

 

    return productRepository.updateProduct(product);

  }

  @Override
  public void removeProduct(UUID resourceId) {
    Product product = productRepository.findByResourceId(resourceId).orElseThrow(() -> new ProductNotFoundException());
    productRepository.removeProduct(product);
  }



  @Override
  public Product getByResourceId(UUID resourceId) {
    return productRepository.findByResourceId(resourceId)
      .orElseThrow(() -> new ProductNotFoundException(resourceId));
  }

}
