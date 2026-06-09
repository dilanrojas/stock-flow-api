package com.stockflow.stockflow_backend.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.stockflow.stockflow_backend.dtos.UserDTOs.UserDTO;
import com.stockflow.stockflow_backend.dtos.UserDTOs.UserRequestDTO;
import com.stockflow.stockflow_backend.entities.User;
import com.stockflow.stockflow_backend.models.UserModels.UserRequestModel;
import com.stockflow.stockflow_backend.models.UserModels.UserResponseModel;

@Component
public class UserMapper {
  public UserDTO toUserDto(User user) {
    if (user == null) {
      return null;
    }

    return new UserDTO(user.getName(), user.getLastName(),  user.getLastName(),user.getEmail(), user.getResourceId());
  } 

  public List<UserDTO> toUserDtoList(List<User> users) {
    if (users == null) {
      return null;
    }

    return users.stream()
      .map(this::toUserDto)
      .collect(Collectors.toList());
  }

  public UserResponseModel toUserResponseModel(UserDTO userDto) {
    if (userDto == null) {
      return null;
    }

    return new UserResponseModel(userDto.name(), userDto.lastName(), userDto.secondLastName(),userDto.email(), userDto.resourceId());
  }

  public List<UserResponseModel> toUserResponseModelList(List<UserDTO> userDtos) {
    if (userDtos == null) {
      return null;
    }

    return userDtos.stream()
      .map(this::toUserResponseModel)
      .collect(Collectors.toList());
  }

  public UserRequestDTO toUserRequestDto(UserRequestModel user) {
    if (user == null) return null;

    UserRequestDTO userDto = new UserRequestDTO();
    userDto.setName(user.name());
    userDto.setLastName(user.lastName());
    userDto.setSecondLastName(user.secondLastName());
    userDto.setEmail(user.email());
    userDto.setPassword(user.password());
    return userDto;
  }
}
