package com.stockflow.stockflow_backend.models.PurchaseModels;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record PurchaseSummaryResponseModel(
    LocalDate date, 
    String reason,
    UUID resourceId,
    BigDecimal purchaseTotal,
    Integer totalProductsAmount

) {}
