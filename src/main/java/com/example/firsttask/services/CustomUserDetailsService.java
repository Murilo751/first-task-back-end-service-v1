package com.example.firsttask.services;

import com.example.firsttask.model.dtoEntity.UserDTO;
import com.example.firsttask.model.entity.User;
import com.example.firsttask.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        UserDTO userDTO = convertToDTO(user.orElse(null));
        List<String> roles = new ArrayList<>();
        roles.add("USER");
        return org.springframework.security.core.userdetails.User.builder().username(userDTO.getEmail()).password(userDTO.getPassword()).roles(roles.toArray(new String[0])).build();
    }

    public UserDTO convertToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
}
