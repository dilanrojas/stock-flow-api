package com.stockflow.stockflow_backend.exceptions;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User not found");
    }

    public UserNotFoundException(UUID resourceId) {
        super("User not found with id: " + resourceId);
    }

    
}
