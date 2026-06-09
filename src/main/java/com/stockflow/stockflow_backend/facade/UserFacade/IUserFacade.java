package com.stockflow.stockflow_backend.facade.UserFacade;

import java.util.List;
import java.util.UUID;

import com.stockflow.stockflow_backend.dtos.UserDTOs.UserDTO;
import com.stockflow.stockflow_backend.dtos.UserDTOs.UserRequestDTO;

public interface IUserFacade {
  List<UserDTO> getAll();  
  UserDTO addUser(UserRequestDTO userDto);
  UserDTO getByResourceId(UUID resourceId);
  UserDTO updateUser(UUID resourceId, UserRequestDTO userDto);
  void removeUser(UUID resourceId);
}
