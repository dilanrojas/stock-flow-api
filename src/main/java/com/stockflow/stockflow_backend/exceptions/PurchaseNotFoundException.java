package com.stockflow.stockflow_backend.exceptions;

import java.util.UUID;

public class PurchaseNotFoundException extends RuntimeException {

    public PurchaseNotFoundException() {
        super("Purchase not found");
    }

    public PurchaseNotFoundException(UUID resourceId) {
        super("Purchase not found with id: " + resourceId);
    }
}
