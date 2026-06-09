package com.stockflow.stockflow_backend.facade.UserFacade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.UserDTOs.UserDTO;
import com.stockflow.stockflow_backend.dtos.UserDTOs.UserRequestDTO;
import com.stockflow.stockflow_backend.entities.User;
import com.stockflow.stockflow_backend.mappers.UserMapper;
import com.stockflow.stockflow_backend.services.UserService.IUserService;

import jakarta.transaction.Transactional;

@Component
public class UserFacade implements IUserFacade {
  @Autowired
  private IUserService userService;
  
  @Autowired
  private UserMapper userMapper;

  @Override
  public List<UserDTO> getAll() {
    return userMapper.toUserDtoList(userService.getAll());
  }

  @Override
  @Transactional
  public UserDTO addUser(UserRequestDTO userDto) {
    User entity = userService.addUser(userDto);
    return userMapper.toUserDto(entity);
  }

  @Override
  public UserDTO getByResourceId(UUID resourceId) {
    User entity = userService.getByResourceId(resourceId);
    return userMapper.toUserDto(entity);
  }

  @Override
  @Transactional
  public UserDTO updateUser(UUID resourceId, UserRequestDTO userDto) {
    User entity = userService.updateUser(resourceId, userDto);
    return userMapper.toUserDto(entity);
  }

  @Override
  @Transactional
  public void removeUser(UUID resourceId) {
    userService.removeUser(resourceId);
  }
}
