package com.stockflow.stockflow_backend.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockflow.stockflow_backend.entities.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

 
    Page<Purchase> findAll(Pageable pageable);

    default Purchase addPurchase(Purchase purchase) {
        return save(purchase);
    }


    @EntityGraph(attributePaths = {
        "purchaseDetails",
        "purchaseDetails.stock",
        "purchaseDetails.stock.product",
    })
    Optional<Purchase> findByResourceId(UUID resourceId);







}