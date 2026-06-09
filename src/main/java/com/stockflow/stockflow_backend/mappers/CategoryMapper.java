package com.stockflow.stockflow_backend.mappers;


import java.util.List;

import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.CategoryDTOs.CategoryDTO;
import com.stockflow.stockflow_backend.dtos.CategoryDTOs.CategoryRequestDTO;
import com.stockflow.stockflow_backend.entities.Category;
import com.stockflow.stockflow_backend.models.CategoryModels.CategoryRequestModel;
import com.stockflow.stockflow_backend.models.CategoryModels.CategoryResponseModel;

@Component
public class CategoryMapper {


    public CategoryDTO toCategoryDTO(Category category){

        if (category == null) {
            return null;
        }

        return new CategoryDTO(category.getName(), category.getResourceId());
    }


    public List<CategoryDTO> toCategoryDTOList(List<Category> categories){

        if (categories == null) {
            return null;
        }

        return categories.stream().
        map(this:: toCategoryDTO).toList();

    }



    public CategoryResponseModel toCategoryResponseModel(CategoryDTO categoryDTO){

        if (categoryDTO == null) {
            return null;

        }

        return new CategoryResponseModel(categoryDTO.name(), categoryDTO.resourceId());
    }



    public List<CategoryResponseModel> toCategoryResponseModelList(List<CategoryDTO> categories){

        if (categories == null) {
            return null;
        }

        return categories.stream().
        map(this::toCategoryResponseModel).toList();

    }


    public CategoryRequestDTO toCategoryRequestDto(CategoryRequestModel categoryRequestModel){
        if (categoryRequestModel == null) {
            return null;
        }

        CategoryRequestDTO categoryRequestDTO = new CategoryRequestDTO();
        categoryRequestDTO.setName(categoryRequestModel.name());

        return categoryRequestDTO;

    }
    
}
