package com.example.firsttask.controller;

import com.example.firsttask.entity.User;
import com.example.firsttask.repository.UserRepository;
import com.example.firsttask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    public registerEntity<User> registerEntity(@Validated @RequestBody User user) {
        User registedUser = userService.registerUser(user);
        return ResponseEntity.ok(registedUser);
    }

//    @GetMapping(value = "/user")
//    Public List<User> getAllUsers() {
//        return userRepository.findAll();
//    };
//
//    @RequestMapping
}
