package com.stockflow.stockflow_backend.services.CategoryService;

import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.CategoryDTOs.CategoryRequestDTO;
import com.stockflow.stockflow_backend.entities.Category;

public interface ICategoryService {

    List<Category> getAll();
    Category addCategory(CategoryRequestDTO categoryRequestDTO);
    Category updateCategory(UUID resourceId, CategoryRequestDTO categoryRequestDTO);
    Category getByResourceId(UUID resourceId);
    void removeCategory(Category category);
    
}
