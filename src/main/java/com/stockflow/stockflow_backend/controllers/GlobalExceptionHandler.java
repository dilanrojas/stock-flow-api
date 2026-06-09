package com.stockflow.stockflow_backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.stockflow.stockflow_backend.dtos.ErrorDTO;
import com.stockflow.stockflow_backend.exceptions.CategoryNotFoundException;
import com.stockflow.stockflow_backend.exceptions.ProductNotFoundException;
import com.stockflow.stockflow_backend.exceptions.PurchaseNotFoundException;
import com.stockflow.stockflow_backend.exceptions.StockNotFoundException;
import com.stockflow.stockflow_backend.exceptions.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ProductNotFoundException.class)
  public ResponseEntity<ErrorDTO> handleProductNotFound(
      ProductNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErrorDTO(
            404,
            ex.getMessage()));
  }

  @ExceptionHandler(CategoryNotFoundException.class)
  public ResponseEntity<ErrorDTO> handleCategoryNotFound(
      CategoryNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErrorDTO(
            404,
            ex.getMessage()));

  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorDTO> handleUserNotFound(
      UserNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErrorDTO(
            404,
            ex.getMessage()));

  }

  @ExceptionHandler(StockNotFoundException.class)
  public ResponseEntity<ErrorDTO> handleStockNotFound(
      StockNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErrorDTO(404, ex.getMessage()));
  }

  @ExceptionHandler(PurchaseNotFoundException.class)
  public ResponseEntity<ErrorDTO> handlePurchaseNotFound(
      PurchaseNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErrorDTO(
            404,
            ex.getMessage()));
  }

 
}
