package com.example.firsttask.services;

import com.example.firsttask.entity.User;
import com.example.firsttask.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUsersById(long id) {
        return userRepository.findById(id);
    }
}
