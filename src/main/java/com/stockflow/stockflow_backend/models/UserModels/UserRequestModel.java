package com.stockflow.stockflow_backend.models.UserModels;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestModel(
  @NotBlank(message = "Name field is required") String name,
  @NotBlank(message = "Last name field is required") String lastName,
  @NotBlank(message = "Second last name field is required") String secondLastName,
  @NotBlank(message = "Email field is required") @Email(message = "Email should be valid") String email,
  @NotBlank(message = "Password field is required") String password
) {}
