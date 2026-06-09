package com.stockflow.stockflow_backend.facade.CategoryFacade;

import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.CategoryDTOs.CategoryDTO;
import com.stockflow.stockflow_backend.dtos.CategoryDTOs.CategoryRequestDTO;

public interface ICategoryFacade {

    List<CategoryDTO> getAll();
    CategoryDTO addCategory(CategoryRequestDTO categoryRequestDTO);
    CategoryDTO updateCategory(UUID resourceId, CategoryRequestDTO categoryRequestDTO);
    CategoryDTO getByResourceId(UUID resourceId);
    void removeCategory(UUID resourceId);
    
}
