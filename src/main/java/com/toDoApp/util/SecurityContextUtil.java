package com.toDoApp.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class SecurityContextUtil {
	private String id;
	private LocalDate currentDate;
	private String username;
	private int roleId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getCurrentDate() {
		currentDate = LocalDate.now();
		return currentDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
