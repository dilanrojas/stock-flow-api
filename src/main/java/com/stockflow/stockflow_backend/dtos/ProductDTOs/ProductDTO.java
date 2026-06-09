package com.stockflow.stockflow_backend.dtos.ProductDTOs;

import java.math.BigDecimal;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.CategoryDTOs.CategoryDTO;

public record ProductDTO (
  String name,
  String description,
  BigDecimal price,
  UUID resourceId,
  CategoryDTO categoryDTO,
  String imageURL
) {}
