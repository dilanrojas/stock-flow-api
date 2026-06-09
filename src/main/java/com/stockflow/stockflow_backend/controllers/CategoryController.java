package com.stockflow.stockflow_backend.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.stockflow_backend.dtos.CategoryDTOs.CategoryDTO;
import com.stockflow.stockflow_backend.dtos.CategoryDTOs.CategoryRequestDTO;
import com.stockflow.stockflow_backend.facade.CategoryFacade.ICategoryFacade;
import com.stockflow.stockflow_backend.mappers.CategoryMapper;
import com.stockflow.stockflow_backend.models.CategoryModels.CategoryRequestModel;
import com.stockflow.stockflow_backend.models.CategoryModels.CategoryResponseModel;

import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryFacade categoryFacade;

    @Autowired
    private CategoryMapper categoryMapper;


    @GetMapping
    public ResponseEntity<List<CategoryResponseModel>> findAll(){
        return ResponseEntity.ok(categoryMapper.toCategoryResponseModelList(categoryFacade.getAll()));

    }

    @GetMapping(path = "/{resourceId}")
    public ResponseEntity<CategoryResponseModel> findByResourceId(@PathVariable("resourceId") UUID resourceId){
       CategoryDTO categoryDTO = categoryFacade.getByResourceId(resourceId);
       return ResponseEntity.ok(categoryMapper.toCategoryResponseModel(categoryDTO));
    }


    @PostMapping
    public ResponseEntity<CategoryResponseModel> add(@RequestBody @Valid CategoryRequestModel categoryRequestModel){
        CategoryRequestDTO dto = categoryMapper.toCategoryRequestDto(categoryRequestModel);
        CategoryDTO categoryDTO = categoryFacade.addCategory(dto);

        return ResponseEntity.ok(categoryMapper.toCategoryResponseModel(categoryDTO));

    }


    @PutMapping(path = "/{resourceId}")
    public ResponseEntity<CategoryResponseModel> update(@RequestBody @Valid CategoryRequestModel categoryRequestModel, @PathVariable("resourceId")UUID resourceId){
        CategoryRequestDTO dto = categoryMapper.toCategoryRequestDto(categoryRequestModel);
        CategoryDTO categoryDTO = categoryFacade.updateCategory(resourceId, dto);
        
        return ResponseEntity.ok(categoryMapper.toCategoryResponseModel(categoryDTO));

    }


    @DeleteMapping(path = "/{resourceId}")
    public void remove(@PathVariable("resourceId")UUID resourceId){
        categoryFacade.removeCategory(resourceId);
    }


  
    
}
