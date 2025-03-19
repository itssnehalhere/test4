package com.UserLogin.UserLogin.controller;

import com.UserLogin.UserLogin.Entity.UserEntity;
import com.UserLogin.UserLogin.dto.userDto;
import com.UserLogin.UserLogin.service.userService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userController {
    int x=10;
    @Autowired
    userService userservice;

    //http://localhost:8080/addUser
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@Valid @RequestBody userDto dto, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.OK);
        }
    userDto userDto = userservice.addUser(dto);
    return new ResponseEntity<>(userDto, HttpStatus.CREATED);

    }
    //http://localhost:8080/deleteUser

    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestParam long id){
    userservice.deleteUser(id);
    return new ResponseEntity<>("record is deleted", HttpStatus.OK);

    }

    //http://localhost:8080/1

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable long id, @RequestBody userDto dto){
    UserEntity entity=userservice.updateUser(id,dto);
    return new ResponseEntity<>(entity, HttpStatus.OK);
    }
    //http://localhost:8080/getAllUsers
    //http://localhost:8080
    //http://localhost:8080/getUsers


    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserEntity>> getAllUsers(@RequestBody userDto dto){
    List<UserEntity> entities=userservice.getAllUsers();
    return new ResponseEntity<>(entities,HttpStatus.OK);
    }

    //http://localhost:8080/getUserById?id=2

    @GetMapping("/getUserById")
    public ResponseEntity<UserEntity> getUserById(@RequestParam long id){
    UserEntity entity=userservice.getUserById(id);
    return new ResponseEntity<>(entity, HttpStatus.OK);
    }

}
