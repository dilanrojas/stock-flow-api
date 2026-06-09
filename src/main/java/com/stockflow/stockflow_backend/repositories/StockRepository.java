package com.stockflow.stockflow_backend.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.stockflow.stockflow_backend.entities.Stock;
import java.util.UUID;


public interface StockRepository extends JpaRepository<Stock, Long> {

   
     Page<Stock> findAll(Pageable pageable);
    
    Optional<Stock> findByResourceId(UUID resourceId);
}
