package com.example.stockflowapi.facade;

import java.util.List;
import java.util.UUID;

import com.example.stockflowapi.dtos.UserDto;
import com.example.stockflowapi.dtos.UserRequestDto;

public interface IUserFacade {
  List<UserDto> getAll();  
  UserDto addUser(UserRequestDto userDto);
  UserDto getByResourceId(UUID resourceId);
  UserDto updateUser(UUID resourceId, UserRequestDto userDto);
  void removeUser(UUID resourceId);
}
