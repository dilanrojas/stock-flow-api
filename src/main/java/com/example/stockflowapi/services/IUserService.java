package com.example.stockflowapi.services;

import java.util.List;
import java.util.UUID;

import com.example.stockflowapi.dtos.UserRequestDto;
import com.example.stockflowapi.entities.User;

public interface IUserService {
  List<User> getAll();  
  User addUser(UserRequestDto userDto);
  User getByResourceId(UUID resourceId);
  User updateUser(UUID resourceId, UserRequestDto userDto);
  void removeUser(UUID resourceId);
}
