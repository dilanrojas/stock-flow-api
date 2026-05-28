package com.example.stockflowapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.stockflowapi.entities.Product;
import java.util.UUID;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  default List<Product> getAll() {
    return findAll();
  }

  default Product addProduct(Product product) {
    return save(product);
  }

  Optional<Product> findByResourceId(UUID resourceId);

  default Product getByResourceId(UUID resourceId) {
    return this.findByResourceId(resourceId).orElse(null);
  }

  default Product updateProduct(Product product) {
    return save(product);
  }
}