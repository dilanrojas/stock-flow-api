package com.stockflow.stockflow_backend.services.UserService;

import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.UserDTOs.UserRequestDTO;
import com.stockflow.stockflow_backend.entities.User;

public interface IUserService {
  List<User> getAll();  
  User addUser(UserRequestDTO userDto);
  User getByResourceId(UUID resourceId);
  User updateUser(UUID resourceId, UserRequestDTO userDto);
  void removeUser(UUID resourceId);
}
