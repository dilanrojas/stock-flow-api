package com.example.stockflowapi.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDto (
  String name,
  String description,
  BigDecimal price,
  UUID resourceId
) {}
