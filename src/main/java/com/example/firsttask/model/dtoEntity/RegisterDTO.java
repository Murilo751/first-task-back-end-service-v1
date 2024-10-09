package com.example.firsttask.model.dtoEntity;

import com.example.firsttask.model.entity.UserRole;

public record RegisterDTO(String email, String password, UserRole role) {
}
