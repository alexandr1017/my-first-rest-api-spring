package com.example.firstsSpringRestApi.repository;

import com.example.firstsSpringRestApi.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository <UserEntity,Long> {
    UserEntity findByUsername(String username);
}
