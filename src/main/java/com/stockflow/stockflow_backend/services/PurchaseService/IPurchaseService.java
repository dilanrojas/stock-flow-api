package com.stockflow.stockflow_backend.services.PurchaseService;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseRequestDTO;
import com.stockflow.stockflow_backend.entities.Purchase;

public interface IPurchaseService {
    Page<Purchase> getAll(int page);
    Purchase addPurchase(PurchaseRequestDTO dto);
    Purchase getByResourceId(UUID resourceId);
    
}
