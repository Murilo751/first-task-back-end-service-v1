package com.example.firsttask.controller;

import com.example.firsttask.entity.User;
import com.example.firsttask.repository.UserRepository;
import com.example.firsttask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Validated @RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(required = true) Long id) {
        return userService.getUsersById(id)
                .map(user -> registerUser(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    };
}
