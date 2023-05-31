package com.example.firstsSpringRestApi.model;

import com.example.firstsSpringRestApi.entity.TodoEntity;
import com.example.firstsSpringRestApi.entity.UserEntity;

public class Todo {
    private Long id;
    private String title;
    private Boolean completed;

    public Todo() {
    }

    public static Todo toModel (TodoEntity entity) {
        Todo model = new Todo();
        model.setId(entity.getId());
        model.setCompleted(entity.getCompleted());
        model.setTitle(entity.getTitle());
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
