package com.toDoApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_table")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	@Column(name = "user_name", nullable = false)
	private String userName;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "role_id", nullable = false)
	private int roleId;	
}
