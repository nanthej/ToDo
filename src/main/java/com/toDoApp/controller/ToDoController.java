package com.toDoApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.toDoApp.requestDto.ToDoRequestDto;
import com.toDoApp.responseDto.ToDoResponseDto;
import com.toDoApp.service.ToDoService;

@RestController
@RequestMapping("/toDo")
public class ToDoController {
	@Autowired
	private ToDoService toDoService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<ToDoResponseDto> saveToDoTask(@RequestBody ToDoRequestDto toDoRequestDto) {
		ResponseEntity<ToDoResponseDto> toDoResponseDto;
		toDoResponseDto = toDoService.saveToDoTask(toDoRequestDto);
		return toDoResponseDto;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ToDoResponseDto> updateToDoTask(@RequestBody ToDoRequestDto toDoRequestDto,@PathVariable Long id) {
		ResponseEntity<ToDoResponseDto> toDoResponseDto;
		toDoResponseDto = toDoService.updateToDoTask(toDoRequestDto,id);
		return toDoResponseDto;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ToDoResponseDto>> getAllToDoTask() {
		ResponseEntity<List<ToDoResponseDto>> toDoResponseDtoList;
		toDoResponseDtoList = toDoService.getAllTask();
		return toDoResponseDtoList;
	}
	
	@DeleteMapping("/{id}")
	public String deleteToDo(@PathVariable Long id) {
		String deletedMessage=null;
		deletedMessage = toDoService.deleteById(id);
		return deletedMessage;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ToDoResponseDto> getById(@PathVariable Long id) {
		ResponseEntity<ToDoResponseDto> toDoResponseDto;
		toDoResponseDto = toDoService.getById(id);
		return toDoResponseDto;
	}
}
