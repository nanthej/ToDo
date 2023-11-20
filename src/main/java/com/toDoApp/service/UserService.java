package com.toDoApp.service;

import org.springframework.http.ResponseEntity;

import com.toDoApp.requestDto.UserDto;
import com.toDoApp.responseDto.UserResponseDto;

public interface UserService {

	ResponseEntity<UserResponseDto> saveUser(UserDto userDto);

}
