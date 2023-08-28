package com.example.validationexceptionhandling.repository;

import com.example.validationexceptionhandling.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
