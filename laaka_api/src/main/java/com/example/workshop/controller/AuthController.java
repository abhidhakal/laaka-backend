package com.example.workshop.controller;

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

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final AuthenticateService authenticateService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest request) {
        logger.info("Signup request received: {}", request.getEmail());
        try {
            // Check if the user already exists
            Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
            if (existingUser.isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already in use");
            }

            // If the user does not exist, proceed to create a new user
            User newUser = new User();
            newUser.setEmail(request.getEmail());
            newUser.setPassword(passwordEncoder.encode(request.getPassword()));
            newUser.setFullname(request.getFullname());
            newUser.setContact(request.getContact());
            newUser.setAddress(request.getAddress());
            userRepository.save(newUser);

            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            logger.error("Error during signup", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during signup");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        logger.info("Login request received: {}", request.getEmail());
        try {
            AuthenticateResponse response = authenticateService.authenticate(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Login failed for user: {}", request.getEmail(), e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
