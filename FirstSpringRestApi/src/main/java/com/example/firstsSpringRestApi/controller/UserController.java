package com.example.firstsSpringRestApi.controller;

import com.example.firstsSpringRestApi.entity.UserEntity;
import com.example.firstsSpringRestApi.exception.UserAlreadyExistException;
import com.example.firstsSpringRestApi.exception.UserNotFoundException;
import com.example.firstsSpringRestApi.model.User;
import com.example.firstsSpringRestApi.repository.UserRepo;
import com.example.firstsSpringRestApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Класс отвечает за логику связанную с пользователем
@RestController
@RequestMapping("/users") //запросы, которые обрабатывает этот контроллер начинаются с URL /users
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok().body("Пользователь успешно сохранён!");
        } catch (UserAlreadyExistException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка????");

        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok().body(userService.getOne(id));
        } catch (UserNotFoundException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(userService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
