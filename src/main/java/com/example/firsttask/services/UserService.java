package com.example.firsttask.services;

import com.example.firsttask.entity.User;
import com.example.firsttask.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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

    public List<User> getAllUsers() {return userRepository.findAll();}

    public User updateUser(User user, long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User updatedUser = userOptional.get();
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
            return userRepository.save(updatedUser);
        }
        return null;
    }

    public boolean deleteUserById(long id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }else {return false;}
    }
}
