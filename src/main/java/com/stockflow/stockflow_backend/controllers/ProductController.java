package com.stockflow.stockflow_backend.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.stockflow_backend.dtos.ProductDTOs.ProductDTO;
import com.stockflow.stockflow_backend.dtos.ProductDTOs.ProductRequestDTO;
import com.stockflow.stockflow_backend.facade.ProductFacade.IProductFacade;
import com.stockflow.stockflow_backend.mappers.ProductMapper;
import com.stockflow.stockflow_backend.models.ProductModels.ProductRequestModel;
import com.stockflow.stockflow_backend.models.ProductModels.ProductResponseModel;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("*")
@RequestMapping("/products")

public class ProductController {
  @Autowired
  private IProductFacade productFacade;
  
  @Autowired
  private ProductMapper productMapper;

  @GetMapping
  public ResponseEntity<List<ProductResponseModel>> findAll() {
    return ResponseEntity.ok(productMapper.toProductResponseModelList(productFacade.getAll()));
  }

  @PostMapping
  public ResponseEntity<ProductResponseModel> add(@RequestBody @Valid ProductRequestModel productRequestModel) {
    ProductRequestDTO dto = productMapper.toProductRequestDto(productRequestModel);
    ProductDTO productDto = productFacade.addProduct(dto);

    return ResponseEntity.ok(productMapper.toProductResponseModel(productDto));
  }
  
  @GetMapping(path = "/{resourceId}")
  public ResponseEntity<ProductResponseModel> findById(@PathVariable("resourceId") UUID resourceId) {
    ProductDTO productDto = productFacade.getByResourceId(resourceId);
    return ResponseEntity.ok(productMapper.toProductResponseModel(productDto));
  }

  @PutMapping(path = "/{resourceId}")
  public ResponseEntity<ProductResponseModel> update(@PathVariable("resourceId") UUID resourceId, @RequestBody @Valid ProductRequestModel productRequestModel) {
    ProductRequestDTO dto = productMapper.toProductRequestDto(productRequestModel);
    ProductDTO productDto = productFacade.updateProduct(resourceId, dto);

    return ResponseEntity.ok(productMapper.toProductResponseModel(productDto));
  }

  @DeleteMapping(path = "/{resourceId}")
  public void delete(@PathVariable("resourceId") UUID resourceId) {
    productFacade.removeProduct(resourceId);
  }
}
