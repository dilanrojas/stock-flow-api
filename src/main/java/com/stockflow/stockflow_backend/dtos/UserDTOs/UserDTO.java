package com.stockflow.stockflow_backend.dtos.UserDTOs;

import java.util.UUID;

public record UserDTO (
  String name,
  String lastName,
  String secondLastName,
  String email,
  UUID resourceId
) {}
