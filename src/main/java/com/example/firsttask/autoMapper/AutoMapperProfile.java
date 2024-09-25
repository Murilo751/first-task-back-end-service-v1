package com.example.firsttask.autoMapper;

import com.example.firsttask.dto.dtoEntity.UserDTO;
import com.example.firsttask.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoMapperProfile {

    @Bean
    public AutoMapperProfile

    public static UserDTO toUserDTO(User user) {
        if(user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public static User toEntity(UserDTO userDTO) {
        if(userDTO == null) {
            return null;
        }
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }

}
