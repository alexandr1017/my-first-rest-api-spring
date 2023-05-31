package com.example.firstsSpringRestApi.repository;

import com.example.firstsSpringRestApi.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity,Long> {
}
