package com.stockflow.stockflow_backend.exceptions;

import java.util.UUID;

public class CategoryNotFoundException extends RuntimeException {


    public CategoryNotFoundException(){
        super("Category Not Found");
    }

    public CategoryNotFoundException(UUID resourceId){
        super("Category Not Found with ID: " + resourceId);
    }

   
    
}
