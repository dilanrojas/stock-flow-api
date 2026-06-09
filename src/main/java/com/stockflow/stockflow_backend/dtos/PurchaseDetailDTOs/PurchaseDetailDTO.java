package com.stockflow.stockflow_backend.dtos.PurchaseDetailDTOs;

import java.math.BigDecimal;
import java.util.UUID;


public record PurchaseDetailDTO(
    UUID resourceId,
    String productName,
    String imageURL,
    Integer quantity,
    BigDecimal unitPrice,
    BigDecimal subtotal
) {}