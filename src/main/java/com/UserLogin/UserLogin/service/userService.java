package com.UserLogin.UserLogin.service;

import com.UserLogin.UserLogin.Entity.UserEntity;
import com.UserLogin.UserLogin.dto.userDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface userService {

    userDto addUser(userDto dto);


    void deleteUser(long id);

    UserEntity updateUser(long id, userDto dto);

    List<UserEntity> getAllUsers();

    UserEntity getUserById(long id);
}
