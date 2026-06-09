package com.stockflow.stockflow_backend.services.UserService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockflow.stockflow_backend.dtos.UserDTOs.UserRequestDTO;
import com.stockflow.stockflow_backend.entities.User;
import com.stockflow.stockflow_backend.exceptions.UserNotFoundException;
import com.stockflow.stockflow_backend.repositories.UserRepository;

@Service
public class UserService implements IUserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> getAll() {
    return userRepository.getAll();
  }

  @Override
  public User addUser(UserRequestDTO userDto) {
    User user = User
      .builder()
      .name(userDto.getName())
      .lastName(userDto.getLastName())
      .secondLastName(userDto.getSecondLastName())
      .email(userDto.getEmail())
      .password(userDto.getPassword())
      .resourceId(UUID.randomUUID())
      .build();
    return userRepository.addUser(user);
  }

  @Override
  public User getByResourceId(UUID resourceId) {
    return userRepository.findByResourceId(resourceId)
      .orElseThrow(() -> new UserNotFoundException(resourceId));
  }

  @Override
  public User updateUser(UUID resourceId, UserRequestDTO userDto) {
    User user = userRepository.findByResourceId(resourceId).orElseThrow(() -> new UserNotFoundException());
    user.setName(userDto.getName());
    user.setLastName(userDto.getLastName());
    user.setSecondLastName(userDto.getSecondLastName());
    user.setEmail(userDto.getEmail());
    user.setPassword(userDto.getPassword());
    return userRepository.updateUser(user);
  }

  @Override
  public void removeUser(UUID resourceId) {
    User user = userRepository.findByResourceId(resourceId).orElseThrow(() -> new UserNotFoundException());
    userRepository.removeUser(user);
  }
}
