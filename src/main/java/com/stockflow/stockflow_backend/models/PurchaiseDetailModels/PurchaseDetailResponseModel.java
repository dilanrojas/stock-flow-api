package com.stockflow.stockflow_backend.models.PurchaiseDetailModels;


import java.math.BigDecimal;
import java.util.UUID;


public record PurchaseDetailResponseModel(
    UUID resourceId,
    String productName,
    String imageURL,
    Integer quantity,
    BigDecimal unitPrice,
    BigDecimal subtotal
) {}