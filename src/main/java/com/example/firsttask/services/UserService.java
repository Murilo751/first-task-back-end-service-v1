package com.example.firsttask.services;

import com.example.firsttask.entity.User;
import com.example.firsttask.dto.dtoEntity.UserDTO;
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

    public User registerUser(User user) {return userRepository.save(user);}

    public UserDTO getUsersById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return UserDTO.fromDomain(user);
    }

    public List<UserDTO> getAllUsers() {return userRepository.findAll();}

    public User updateUser(User user, Long id) {
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

    public boolean deleteUserById(Long id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }else {return false;}
    }

    public UserDTO convertToDTO(User user){
        return new UserDTO(user.getName(), user.getEmail(), user.getPassword());
    }

    public UserDTO convertToDTO(User user, UserDTO userDTO){}


}
