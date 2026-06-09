package com.stockflow.stockflow_backend.dtos.ProductDTOs;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {
  private String name;
  private String description;
  private BigDecimal price;
  private UUID categoryResourceId;
  private String imageURL;
  private Integer minimumQuantity;
}
