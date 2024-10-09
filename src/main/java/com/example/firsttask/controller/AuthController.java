package com.example.firsttask.controller;

import com.example.firsttask.auth.JwtUtil;
import com.example.firsttask.model.dtoEntity.AuthDTO;
import com.example.firsttask.model.dtoEntity.RegisterDTO;
import com.example.firsttask.model.dtoEntity.UserDTO;
import com.example.firsttask.model.entity.User;
import com.example.firsttask.model.request.LoginRequest;
import com.example.firsttask.model.response.LoginResponse;
import com.example.firsttask.repository.UserRepository;
import com.example.firsttask.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO authDTO) {
        var emailPassword = new UsernamePasswordAuthenticationToken(authDTO.email(), authDTO.password());
        var authentication = authenticationManager.authenticate(emailPassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody @Valid RegisterDTO registerDTO) {
        if (this.userRepository.findUserByEmail(registerDTO.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        User newUser = new User(registerDTO.email(), encryptedPassword, registerDTO.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

}
