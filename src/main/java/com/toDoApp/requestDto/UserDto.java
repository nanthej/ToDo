package com.toDoApp.requestDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	private Long userId;
	
	private String userName;

	private String password;

	private int roleId;
}
