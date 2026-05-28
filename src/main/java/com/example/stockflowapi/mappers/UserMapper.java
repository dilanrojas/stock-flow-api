package com.example.stockflowapi.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.stockflowapi.dtos.UserDto;
import com.example.stockflowapi.dtos.UserRequestDto;
import com.example.stockflowapi.entities.User;
import com.example.stockflowapi.models.UserRequestModel;
import com.example.stockflowapi.models.UserResponseModel;

@Component
public class UserMapper {
  public UserDto toUserDto(User user) {
    if (user == null) {
      return null;
    }

    return new UserDto(user.getName(), user.getLastName(), user.getEmail(), user.getResourceId());
  } 

  public List<UserDto> toUserDtoList(List<User> users) {
    if (users == null) {
      return null;
    }

    return users.stream()
      .map(this::toUserDto)
      .collect(Collectors.toList());
  }

  public UserResponseModel toUserResponseModel(UserDto userDto) {
    if (userDto == null) {
      return null;
    }

    return new UserResponseModel(userDto.name(), userDto.lastName(), userDto.email(), userDto.resourceId());
  }

  public List<UserResponseModel> toUserResponseModelList(List<UserDto> userDtos) {
    if (userDtos == null) {
      return null;
    }

    return userDtos.stream()
      .map(this::toUserResponseModel)
      .collect(Collectors.toList());
  }

  public UserRequestDto toUserRequestDto(UserRequestModel user) {
    if (user == null) return null;

    UserRequestDto userDto = new UserRequestDto();
    userDto.setName(user.name());
    userDto.setLastName(user.lastName());
    userDto.setEmail(user.email());
    userDto.setPassword(user.password());
    return userDto;
  }
}
