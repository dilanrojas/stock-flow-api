package com.stockflow.stockflow_backend.dtos.PurchaseDTOs;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs.PurchaseDetailDTO;

public record PurchaseDTO (
    LocalDate date, 
    String reason,
    UUID resourceId,
    BigDecimal purchaseTotal,
    Integer totalProductsAmount,
    List<PurchaseDetailDTO> purchaseDetails
) {}


