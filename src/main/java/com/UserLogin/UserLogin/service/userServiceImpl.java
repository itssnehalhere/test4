package com.UserLogin.UserLogin.service;

import com.UserLogin.UserLogin.Entity.UserEntity;
import com.UserLogin.UserLogin.dto.userDto;
import com.UserLogin.UserLogin.exception.ResourceNotFoundException;
import com.UserLogin.UserLogin.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userServiceImpl implements userService{
    @Autowired
    UserEntityRepository ur;
    @Override
    public userDto addUser(userDto dto) {
        UserEntity userEntity=dtoToEntity(dto);
        UserEntity savedEntity = ur.save(userEntity);
        userDto ud=entityToDto(savedEntity);
        return ud;


    }
    UserEntity dtoToEntity(userDto dto){
        UserEntity userEntity=new UserEntity();
        userEntity.setEmailId(dto.getEmailId());
        userEntity.setMobile(dto.getMobile());
        userEntity.setName(dto.getName());
        return userEntity;
    }
    userDto entityToDto(UserEntity savedEntity){
        userDto ud=new userDto();
        ud.setEmailId(savedEntity.getEmailId());
        ud.setMobile(savedEntity.getMobile());
        ud.setName(savedEntity.getName());
        ud.setId(savedEntity.getId());
        return ud;
    }

    @Override
    public void deleteUser(long id) {
        ur.deleteById(id);
    }

    @Override
    public UserEntity updateUser(long id, userDto dto) {
        Optional<UserEntity> byId = ur.findById(id);
        UserEntity userEntity = byId.get();
        userEntity.setEmailId(dto.getEmailId());
        userEntity.setMobile(dto.getMobile());
        userEntity.setName(dto.getName());
        ur.save(userEntity);
        return userEntity;

    }

    @Override
    public List<UserEntity> getAllUsers() {
        List<UserEntity> all = ur.findAll();
        return all;
    }

    @Override
    public UserEntity getUserById(long id) {
        UserEntity userEntity = ur.findById(id).orElseThrow(()->new ResourceNotFoundException("user not found with id: "+id)
        );
        return userEntity;
    }
}
