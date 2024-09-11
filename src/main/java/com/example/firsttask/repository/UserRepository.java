package com.example.firsttask.repository;

import com.example.firsttask.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { }
