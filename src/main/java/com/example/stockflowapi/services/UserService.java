package com.example.stockflowapi.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockflowapi.dtos.UserRequestDto;
import com.example.stockflowapi.entities.User;
import com.example.stockflowapi.exceptions.UserNotFoundException;
import com.example.stockflowapi.repositories.UserRepository;

@Service
public class UserService implements IUserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> getAll() {
    return userRepository.getAll();
  }

  @Override
  public User addUser(UserRequestDto userDto) {
    var user = User
      .builder()
      .name(userDto.getName())
      .lastName(userDto.getLastName())
      .email(userDto.getEmail())
      .password(userDto.getPassword())
      .resourceId(UUID.randomUUID())
      .build();
    return userRepository.addUser(user);
  }

  @Override
  public User getByResourceId(UUID resourceId) {
    return userRepository.findByResourceId(resourceId)
      .orElseThrow(() -> new UserNotFoundException("User not found"));
  }

  @Override
  public User updateUser(UUID resourceId, UserRequestDto userDto) {
    var user = userRepository.findByResourceId(resourceId).orElseThrow(() -> new RuntimeException("User not found"));
    user.setName(userDto.getName());
    user.setLastName(userDto.getLastName());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());
    return userRepository.updateUser(user);
  }

  @Override
  public void removeUser(UUID resourceId) {
    var user = userRepository.findByResourceId(resourceId).orElseThrow(() -> new RuntimeException("User not found"));
    userRepository.delete(user);
  }
}
