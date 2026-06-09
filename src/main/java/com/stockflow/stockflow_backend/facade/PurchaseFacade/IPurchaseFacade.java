package com.stockflow.stockflow_backend.facade.PurchaseFacade;

import java.util.UUID;

import org.springframework.data.domain.Page;

import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseDTO;
import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseRequestDTO;
import com.stockflow.stockflow_backend.dtos.PurchaseDTOs.PurchaseSummaryDTO;

public interface IPurchaseFacade {
    Page<PurchaseSummaryDTO> getAll(int page);
    PurchaseDTO addPurchase(PurchaseRequestDTO dto);
    PurchaseDTO getByResourceId(UUID resourceId);
 
}
