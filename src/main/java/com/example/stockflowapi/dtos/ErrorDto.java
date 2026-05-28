package com.example.stockflowapi.dtos;

public class ErrorDto {
  int status;
  String message;

  public ErrorDto(int status, String message) {
    this.status = status;
    this.message = message;
  }
}