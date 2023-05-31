package com.example.firstsSpringRestApi.service;

import com.example.firstsSpringRestApi.entity.UserEntity;
import com.example.firstsSpringRestApi.exception.UserAlreadyExistException;
import com.example.firstsSpringRestApi.exception.UserNotFoundException;
import com.example.firstsSpringRestApi.model.User;
import com.example.firstsSpringRestApi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public UserEntity registration (UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByUsername(user.getUsername()) !=null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует!");
        }
        return userRepo.save(user);
    }
    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user==null) {
            throw new UserNotFoundException("Пользователь не был найден");
        }
        return User.toModel(user);
    }


    public Long delete (Long id) {
        userRepo.deleteById(id);
        return id;
    }

}
