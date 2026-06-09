package com.stockflow.stockflow_backend.exceptions;

import java.util.UUID;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("Product not found");
    }

    public ProductNotFoundException(UUID resourceId) {
        super("Product not found with id: " + resourceId);
    }

}