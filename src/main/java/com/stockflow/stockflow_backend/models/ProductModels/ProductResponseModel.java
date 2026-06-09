package com.stockflow.stockflow_backend.models.ProductModels;

import java.math.BigDecimal;
import java.util.UUID;

import com.stockflow.stockflow_backend.models.CategoryModels.CategoryResponseModel;

public record ProductResponseModel (
  String name,
  String description,
  BigDecimal price,
  UUID resourceId,
  CategoryResponseModel categoryResponseModel,
  String imageURL
) {}
