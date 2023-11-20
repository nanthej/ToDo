package com.toDoApp.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name = "to_do")
public class ToDoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "to_do_id", nullable = false)
	private Long toDoId;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "created_date", nullable = true)
	private LocalDate createdDate;
	
	@Column(name = "created_by", nullable = true)
	private String createdBy;
	
	@Column(name = "modification_date", nullable = true)
	private LocalDate modificationDate;
	
	@Column(name = "modified_user", nullable = true)
	private String modifiedUser;
	
	@Column(name = "estimated_time", nullable = true)
	private Double estimatedTime;
	
	@Column(name = "status", nullable = true)
	private String status;
}

