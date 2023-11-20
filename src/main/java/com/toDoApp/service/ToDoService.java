package com.toDoApp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.toDoApp.requestDto.ToDoRequestDto;
import com.toDoApp.responseDto.ToDoResponseDto;

public interface ToDoService {

	ResponseEntity<ToDoResponseDto> saveToDoTask(ToDoRequestDto toDoRequestDto);

	ResponseEntity<ToDoResponseDto> updateToDoTask(ToDoRequestDto toDoRequestDto, Long id);

	ResponseEntity<List<ToDoResponseDto>> getAllTask();

	String deleteById(Long id);

	ResponseEntity<ToDoResponseDto> getById(Long id);
}
