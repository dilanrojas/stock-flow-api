package com.stockflow.stockflow_backend.exceptions;

import java.util.UUID;

public class StockNotFoundException extends RuntimeException {

    public StockNotFoundException(){
        super("Stock not found");
    }
    

    public StockNotFoundException(UUID resourceId){
        super("Stock not found with ID: " + resourceId);

    }
}
