package com.toDoApp.requestDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToDoRequestDto {

	private Long toDoId;

	private String title;

	private String description;

	private LocalDate createdDate;

	private String createdBy;
	
	private LocalDate modificationDate;

	private String modifiedUser;

	private Double estimatedTime;
	
	private String status;


}
