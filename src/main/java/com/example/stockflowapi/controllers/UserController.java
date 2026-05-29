package com.example.stockflowapi.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockflowapi.dtos.UserDto;
import com.example.stockflowapi.facade.IUserFacade;
import com.example.stockflowapi.mappers.UserMapper;
import com.example.stockflowapi.models.UserRequestModel;
import com.example.stockflowapi.models.UserResponseModel;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.CrossOrigin;

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
  public UserDto save(@RequestBody UserRequestModel userRequestModel) {
    var dto = userMapper.toUserRequestDto(userRequestModel);
    return userFacade.addUser(dto);
  }
  
  @GetMapping(path = "/{resourceId}")
  public UserDto findById(@PathVariable("resourceId") UUID resourceId) {
    return userFacade.getByResourceId(resourceId);
  }

  @PutMapping(path = "/{resourceId}")
  public UserDto update(@PathVariable("resourceId") UUID resourceId, @RequestBody UserRequestModel userRequestModel) {
    var dto = userMapper.toUserRequestDto(userRequestModel);
    return userFacade.updateUser(resourceId, dto);
  }

  @DeleteMapping(path = "/{resourceId}")
  public void delete(@PathVariable("resourceId") UUID resourceId) {
    userFacade.removeUser(resourceId);
  }
}
