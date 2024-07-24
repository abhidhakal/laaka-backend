package com.example.workshop.controller;

import com.example.workshop.dto.AuthenticateRequest;
import com.example.workshop.dto.AuthenticateResponse;
import com.example.workshop.dto.LoginRequest;
import com.example.workshop.dto.SignupRequest;
import com.example.workshop.entity.User;
import com.example.workshop.repository.UserRepository;
import com.example.workshop.service.AuthenticateService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final AuthenticateService authenticateService;

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
        if (userRepository.findByUsername(signupRequest.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username is already taken.");
        }
        if (userRepository.findByEmail(signupRequest.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email is already taken.");
        }

        // Encode password before saving
        User user = User.builder()
                .username(signupRequest.getUsername())
                .email(signupRequest.getEmail())
                .password(passwordEncoder.encode(signupRequest.getPassword())) // Encode the password
                .fullname(signupRequest.getFullname())
                .contact(signupRequest.getContact())
                .address(signupRequest.getAddress())
                .build();

        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        if ("admin".equals(loginRequest.getUsername()) && "admin".equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(Map.of("role", "admin", "message", "Admin logged in successfully"));
        } else if ("guest".equals(loginRequest.getUsername()) && "password".equals(loginRequest.getPassword())) {
            return ResponseEntity.ok(Map.of("role", "customer", "message", "Customer logged in successfully"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
