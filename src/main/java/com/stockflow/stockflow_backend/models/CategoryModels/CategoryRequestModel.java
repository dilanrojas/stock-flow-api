package com.stockflow.stockflow_backend.models.CategoryModels;


import jakarta.validation.constraints.NotBlank;

public record CategoryRequestModel(
    @NotBlank(message = "Name field can't be null") String name
) {
    
}
