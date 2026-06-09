package com.stockflow.stockflow_backend.models.PurchaseModels;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.models.PurchaiseDetailModels.PurchaseDetailResponseModel;

public record PurchaseResponseModel(
    LocalDate date,
    String reason,
    UUID resourceId,
    BigDecimal purchaseTotal,
    Integer totalProductsAmount,
    List<PurchaseDetailResponseModel> purchaseDetails
) {}