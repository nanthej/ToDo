package com.toDoApp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.toDoApp.entity.ToDoEntity;
import com.toDoApp.repository.ToDoRepository;
import com.toDoApp.requestDto.ToDoRequestDto;
import com.toDoApp.responseDto.ToDoResponseDto;
import com.toDoApp.service.ToDoService;
import com.toDoApp.util.Constants;
import com.toDoApp.util.SecurityContextUtil;

@Service
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	ToDoRepository toDoRepository;

	@Autowired
	private SecurityContextUtil securityContextUtil;

	@Override
	public ResponseEntity<ToDoResponseDto> saveToDoTask(ToDoRequestDto toDoRequestDto) {
		ToDoEntity toDoFinal = new ToDoEntity(), toDo = new ToDoEntity();
		ToDoResponseDto toDoResp = new ToDoResponseDto();
		toDo = covertRequestDtoToToDoEntity(toDoRequestDto, Constants.SAVE);
		toDoFinal = toDoRepository.save(toDo);
		BeanUtils.copyProperties(toDoFinal, toDoResp);
		return ResponseEntity.ok().body(toDoResp);
	}

	private ToDoEntity covertRequestDtoToToDoEntity(ToDoRequestDto toDoRequestDto, String method) {
		ToDoEntity toDo = new ToDoEntity();
		BeanUtils.copyProperties(toDoRequestDto, toDo);
		if (method.equals(Constants.UPDATE)) {
			toDo.setModifiedUser(securityContextUtil.getUsername());
			toDo.setModificationDate(securityContextUtil.getCurrentDate());
			if (toDoRequestDto.getStatus() != null) {
				toDo.setStatus(toDoRequestDto.getStatus());
			}
		} else {
			toDo.setCreatedBy(securityContextUtil.getUsername());
			toDo.setCreatedDate(securityContextUtil.getCurrentDate());
			toDo.setStatus(Constants.NOT_STARTED);
		}
		return toDo;
	}

	@Override
	public ResponseEntity<ToDoResponseDto> updateToDoTask(ToDoRequestDto toDoRequestDto, Long toDoId) {
		ToDoEntity toDoFinal = new ToDoEntity(), oldToDo = new ToDoEntity(), toDo = new ToDoEntity();
		ToDoResponseDto toDoResp = new ToDoResponseDto();
		oldToDo = toDoRepository.findByToDoId(toDoId);
		if (oldToDo != null) {
			toDo = covertRequestDtoToToDoEntity(toDoRequestDto, Constants.UPDATE);
			if (toDo.getStatus() == null) {
				toDo.setStatus(oldToDo.getStatus());
			}
			toDo.setCreatedBy(oldToDo.getCreatedBy());
			toDo.setCreatedDate(oldToDo.getCreatedDate());
			toDo.setToDoId(oldToDo.getToDoId());
			toDoFinal = toDoRepository.save(toDo);
			BeanUtils.copyProperties(toDoFinal, toDoResp);
			return ResponseEntity.ok().body(toDoResp);
		} else {
			return null;
		}
	}

	@Override
	public ResponseEntity<List<ToDoResponseDto>> getAllTask() {
		List<ToDoResponseDto> toDoResponseDtoList = new ArrayList<>();
		List<ToDoEntity> entityList = new ArrayList<>();
		entityList = toDoRepository.findAll();
		for (ToDoEntity toDo : entityList) {
			ToDoResponseDto toDoResp = new ToDoResponseDto();
			BeanUtils.copyProperties(toDo, toDoResp);
			toDoResponseDtoList.add(toDoResp);
		}
		return ResponseEntity.ok().body(toDoResponseDtoList);
	}

	@Override
	public String deleteById(Long toDoId) {
		ToDoEntity toDo = new ToDoEntity();
		toDo = toDoRepository.findByToDoId(toDoId);
		toDoRepository.delete(toDo);
		String message = Constants.DELETED;
		return message;
	}

	@Override
	public ResponseEntity<ToDoResponseDto> getById(Long id) {
		ToDoEntity toDo = new ToDoEntity();
		toDo = toDoRepository.findByToDoId(id);
		ToDoResponseDto toDoResp = new ToDoResponseDto();
		BeanUtils.copyProperties(toDo, toDoResp);
		return ResponseEntity.ok().body(toDoResp);
	}

}
