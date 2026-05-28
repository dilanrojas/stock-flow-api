package com.example.stockflowapi.models;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequestModel(
  @NotBlank(message = "Name field is required") String name,
  String description,
  @NotNull(message = "Price field is required")
  @Positive(message = "Price must be higher than 0") BigDecimal price
) {}