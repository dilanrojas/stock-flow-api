package com.stockflow.stockflow_backend.facade.CategoryFacade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.CategoryDTOs.CategoryDTO;
import com.stockflow.stockflow_backend.dtos.CategoryDTOs.CategoryRequestDTO;
import com.stockflow.stockflow_backend.entities.Category;
import com.stockflow.stockflow_backend.mappers.CategoryMapper;
import com.stockflow.stockflow_backend.services.CategoryService.ICategoryService;

import jakarta.transaction.Transactional;

@Component
public class CategoryFacade implements ICategoryFacade {


    @Autowired
    private ICategoryService categoryService;
    
    @Autowired
    private CategoryMapper categoryMapper;



    @Override
    public List<CategoryDTO> getAll() {

        return categoryMapper.toCategoryDTOList(categoryService.getAll());
    }


    @Override
    @Transactional
    public CategoryDTO addCategory(CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryService.addCategory(categoryRequestDTO);
        return categoryMapper.toCategoryDTO(category);
    }


    @Override
    @Transactional
    public CategoryDTO updateCategory(UUID resourceId, CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryService.updateCategory(resourceId, categoryRequestDTO);
        return categoryMapper.toCategoryDTO(category);
    }

    @Override
    @Transactional
    public void removeCategory(UUID resourceId) {
        Category category = categoryService.getByResourceId(resourceId);
        categoryService.removeCategory(category);        
        
    }


    @Override
    public CategoryDTO getByResourceId(UUID resourceId) {
        Category category = categoryService.getByResourceId(resourceId);
        return categoryMapper.toCategoryDTO(category);
    }

    
}
