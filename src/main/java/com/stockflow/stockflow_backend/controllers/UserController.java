package com.stockflow.stockflow_backend.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockflow.stockflow_backend.dtos.UserDTOs.UserDTO;
import com.stockflow.stockflow_backend.dtos.UserDTOs.UserRequestDTO;
import com.stockflow.stockflow_backend.facade.UserFacade.IUserFacade;
import com.stockflow.stockflow_backend.mappers.UserMapper;
import com.stockflow.stockflow_backend.models.UserModels.UserRequestModel;
import com.stockflow.stockflow_backend.models.UserModels.UserResponseModel;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {

  @Autowired
  private IUserFacade userFacade;
  
  @Autowired
  private UserMapper userMapper;

  @GetMapping
  public ResponseEntity<List<UserResponseModel>> findAll() {
    return ResponseEntity.ok(userMapper.toUserResponseModelList(userFacade.getAll()));
  }

  @PostMapping
  public ResponseEntity<UserResponseModel> add(@RequestBody @Valid UserRequestModel userRequestModel) {
    UserRequestDTO dto = userMapper.toUserRequestDto(userRequestModel);
    UserDTO userDto = userFacade.addUser(dto);

    return ResponseEntity.ok(userMapper.toUserResponseModel(userDto));
  }
  
  @GetMapping(path = "/{resourceId}")
  public ResponseEntity<UserResponseModel> findByResourceId(@PathVariable("resourceId") UUID resourceId) {
    UserDTO userDto = userFacade.getByResourceId(resourceId);
    return ResponseEntity.ok(userMapper.toUserResponseModel(userDto));
  }

  @PutMapping(path = "/{resourceId}")
  public ResponseEntity<UserResponseModel> update(@PathVariable("resourceId") UUID resourceId, @RequestBody @Valid UserRequestModel userRequestModel) {
    UserRequestDTO dto = userMapper.toUserRequestDto(userRequestModel);
    UserDTO userDto = userFacade.updateUser(resourceId, dto);
    
    return ResponseEntity.ok(userMapper.toUserResponseModel(userDto));
  }

  @DeleteMapping(path = "/{resourceId}")
  public void delete(@PathVariable("resourceId") UUID resourceId) {
    userFacade.removeUser(resourceId);
  }
}
