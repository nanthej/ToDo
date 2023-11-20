package com.toDoApp.responseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {

	private Long userId;
	
	private String userName;

	private String password;

	private int roleId;

}
