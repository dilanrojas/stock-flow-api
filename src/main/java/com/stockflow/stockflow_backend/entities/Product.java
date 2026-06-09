package com.stockflow.stockflow_backend.entities;

import java.math.BigDecimal;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false, length = 255)
  private String name;

  @Column(name = "description", length = 500)
  private String description;

  @Column(name = "price", precision = 38, scale = 2, nullable = false)
  private BigDecimal price;

  @Column(name = "resource_id", nullable = false, unique = true, length = 36)
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private UUID resourceId;

  @ManyToOne()
  @JoinColumn(name = "category_id", nullable = false)
  private Category category;

  @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
  private Stock stock;

  @Column(name = "image_url", length = 500)
  private String imageURL;
}