package com.stockflow.stockflow_backend.dtos.PurchaseDTOs;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PurchaseSummaryDTO(
    LocalDate date, 
    String reason,
    UUID resourceId,
    BigDecimal purchaseTotal,
    Integer totalProductsAmount

) {}
