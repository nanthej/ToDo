package com.toDoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toDoApp.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{

}
