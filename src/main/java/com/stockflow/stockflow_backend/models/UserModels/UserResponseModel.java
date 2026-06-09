package com.stockflow.stockflow_backend.models.UserModels;

import java.util.UUID;

public record UserResponseModel (
  String name,
  String lastName,
  String secondLastName,
  String email,
  UUID resourceId
) {}
