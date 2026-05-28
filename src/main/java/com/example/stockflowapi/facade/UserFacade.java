package com.example.stockflowapi.facade;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.stockflowapi.dtos.UserDto;
import com.example.stockflowapi.dtos.UserRequestDto;
import com.example.stockflowapi.mappers.UserMapper;
import com.example.stockflowapi.services.IUserService;

import jakarta.transaction.Transactional;

@Component
public class UserFacade implements IUserFacade {
  @Autowired
  private IUserService userService;
  
  @Autowired
  private UserMapper userMapper;

  @Override
  public List<UserDto> getAll() {
    return userMapper.toUserDtoList(userService.getAll());
  }

  @Override
  @Transactional
  public UserDto addUser(UserRequestDto userDto) {
    var entity = userService.addUser(userDto);
    return userMapper.toUserDto(entity);
  }

  @Override
  public UserDto getByResourceId(UUID resourceId) {
    var entity = userService.getByResourceId(resourceId);
    return userMapper.toUserDto(entity);
  }

  @Override
  @Transactional
  public UserDto updateUser(UUID resourceId, UserRequestDto userDto) {
    var entity = userService.updateUser(resourceId, userDto);
    return userMapper.toUserDto(entity);
  }

  @Override
  @Transactional
  public void removeUser(UUID resourceId) {
    userService.removeUser(resourceId);
  }
}
