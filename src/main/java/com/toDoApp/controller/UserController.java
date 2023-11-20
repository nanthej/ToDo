package com.toDoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.toDoApp.requestDto.UserDto;
import com.toDoApp.responseDto.UserResponseDto;
import com.toDoApp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/saveUser",method = RequestMethod.POST)
	public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserDto userDto) {
		ResponseEntity<UserResponseDto> userResponseDto;
		userResponseDto = userService.saveUser(userDto);
		return userResponseDto;
	}
}
