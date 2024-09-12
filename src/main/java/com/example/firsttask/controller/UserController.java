package com.example.firsttask.controller;

import com.example.firsttask.entity.User;
import com.example.firsttask.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        return userService.getUsersById(id)
                .map(this::registerUser)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
