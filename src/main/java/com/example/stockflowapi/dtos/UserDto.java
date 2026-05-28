package com.example.stockflowapi.dtos;

import java.util.UUID;

public record UserDto (
  String name,
  String lastName,
  String email,
  UUID resourceId
) {}
