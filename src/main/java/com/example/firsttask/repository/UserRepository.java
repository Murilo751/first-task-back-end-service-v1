package com.example.firsttask.repository;

import com.example.firsttask.model.dtoEntity.UserDTO;
import com.example.firsttask.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<UserDTO> findByEmail(String email);

    UserDetails findUserByEmail(String email);
}
