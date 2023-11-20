package com.toDoApp.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.toDoApp.entity.UserEntity;
import com.toDoApp.repository.UserRepository;
import com.toDoApp.requestDto.UserDto;
import com.toDoApp.responseDto.UserResponseDto;
import com.toDoApp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public ResponseEntity<UserResponseDto> saveUser(UserDto userDto) {
		UserEntity userFinal=new UserEntity(),user=new UserEntity();		
		UserResponseDto userResp = new UserResponseDto();
		BeanUtils.copyProperties(userDto, user);
		userFinal=userRepository.save(user);
		BeanUtils.copyProperties(userFinal, userResp);
		return ResponseEntity.ok().body(userResp);
	}

}
