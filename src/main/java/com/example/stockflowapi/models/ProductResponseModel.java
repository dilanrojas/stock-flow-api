package com.example.stockflowapi.models;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponseModel (
  String name,
  String description,
  BigDecimal price,
  UUID resourceId
) {}
