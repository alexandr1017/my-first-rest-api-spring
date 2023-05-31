package com.example.firstsSpringRestApi.service;

import com.example.firstsSpringRestApi.entity.TodoEntity;
import com.example.firstsSpringRestApi.entity.UserEntity;
import com.example.firstsSpringRestApi.model.Todo;
import com.example.firstsSpringRestApi.repository.TodoRepo;
import com.example.firstsSpringRestApi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo completeTodo(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));

    }
}
