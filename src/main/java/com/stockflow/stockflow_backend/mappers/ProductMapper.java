package com.stockflow.stockflow_backend.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.CategoryDTOs.CategoryDTO;
import com.stockflow.stockflow_backend.dtos.ProductDTOs.ProductDTO;
import com.stockflow.stockflow_backend.dtos.ProductDTOs.ProductRequestDTO;
import com.stockflow.stockflow_backend.entities.Product;
import com.stockflow.stockflow_backend.models.CategoryModels.CategoryResponseModel;
import com.stockflow.stockflow_backend.models.ProductModels.ProductRequestModel;
import com.stockflow.stockflow_backend.models.ProductModels.ProductResponseModel;

@Component
public class ProductMapper {
    public ProductDTO toProductDto(Product product) {
    if (product == null) {
      return null;
    }
    CategoryDTO categoryDTO = new CategoryDTO(product.getCategory().getName(), product.getCategory().getResourceId());

    return new ProductDTO(product.getName(), product.getDescription(), product.getPrice(), product.getResourceId(), categoryDTO, product.getImageURL());
  } 

  public List<ProductDTO> toProductDtoList(List<Product> products) {
    if (products == null) {
      return null;
    }

    return products.stream()
      .map(this::toProductDto)
      .collect(Collectors.toList());
  }

  public ProductResponseModel toProductResponseModel(ProductDTO productDto) {
    if (productDto == null) {
      return null;
    }

    CategoryResponseModel categoryResponseModel = new CategoryResponseModel(productDto.categoryDTO().name(), productDto.categoryDTO().resourceId());

    return new ProductResponseModel(productDto.name(), productDto.description(), productDto.price(), productDto.resourceId(), categoryResponseModel, productDto.imageURL());
  }

  public List<ProductResponseModel> toProductResponseModelList(List<ProductDTO> productDtos) {
    if (productDtos == null) {
      return null;
    }

    return productDtos.stream()
      .map(this::toProductResponseModel)
      .collect(Collectors.toList());
  }

  public ProductRequestDTO toProductRequestDto(ProductRequestModel product) {
    if (product == null) return null;

    ProductRequestDTO productDto = new ProductRequestDTO();
    productDto.setName(product.name());
    productDto.setDescription(product.description());
    productDto.setPrice(product.price());
    productDto.setCategoryResourceId(product.categoryResourceId());
    productDto.setImageURL(product.imageURL());
    productDto.setMinimumQuantity(product.minimumQuantity()); 
    return productDto;
  }
}
