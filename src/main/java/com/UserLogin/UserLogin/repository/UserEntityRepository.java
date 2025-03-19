package com.UserLogin.UserLogin.repository;

import com.UserLogin.UserLogin.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
}