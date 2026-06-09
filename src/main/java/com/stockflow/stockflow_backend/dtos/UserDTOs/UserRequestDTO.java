package com.stockflow.stockflow_backend.dtos.UserDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
  private String name;
  private String lastName;
  private String secondLastName;
  private String email;
  private String password;
}
