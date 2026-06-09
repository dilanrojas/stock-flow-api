package com.stockflow.stockflow_backend.models.ProductModels;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequestModel(
 @NotBlank(message = "Name field is required") String name,
  String description,
  @NotNull(message = "Price field is required")
  @Positive(message = "Price must be higher than 0") BigDecimal price,
  @NotNull(message = "Category resource ID field is required") UUID categoryResourceId,
  @Positive(message = "Minimum quantity must be higher than 0") Integer minimumQuantity,
  String imageURL
) {}