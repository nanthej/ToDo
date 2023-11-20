package com.toDoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.toDoApp.entity.ToDoEntity;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoEntity,Long>{

	@Query(value = "select * from to_do where to_do_id=?", nativeQuery = true)
	ToDoEntity findByToDoId(Long toDoId);
}
