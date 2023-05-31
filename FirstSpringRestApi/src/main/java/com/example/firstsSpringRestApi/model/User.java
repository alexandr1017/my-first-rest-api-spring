package com.example.firstsSpringRestApi.model;

import com.example.firstsSpringRestApi.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private Long id;
    private String username;
    private List<Todo> todos;



    public User() {
    }


//Сущности, которые взаимодействуют c базой данных и объекты которыми мы обмениваемся с клиентом это разные классы!
    //Тут мы оборачиваем сущность в модель, отсекая не нужный для передачи пароль. Обмениваемся с клиентом моделями сущностей!
    public static User toModel (UserEntity entity) {
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        //преобразуем лист сущностей (todos) в лист моделей(todos)
        model.setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
