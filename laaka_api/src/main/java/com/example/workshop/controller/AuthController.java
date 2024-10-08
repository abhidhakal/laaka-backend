package com.example.workshop.controller;

import com.example.workshop.dto.AuthenticateRequest;
import com.example.workshop.dto.AuthenticateResponse;
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

    @PostMapping("/signup")  // Fixed URL mapping
    public ResponseEntity<String> signup(@RequestBody SignupRequest request) {
        logger.info("Signup request received for email: {}", request.getEmail());
        try {
            // Check if the user already exists
            Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
            if (existingUser.isPresent()) {
                logger.warn("Signup failed: Email {} already in use", request.getEmail());
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already in use");
            }

            User newUser = new User();
            newUser.setEmail(request.getEmail());
            newUser.setPassword(passwordEncoder.encode(request.getPassword()));
            newUser.setFullname(request.getFullname());
            newUser.setContact(request.getContact());
            newUser.setAddress(request.getAddress());
            userRepository.save(newUser);

            logger.info("User registered successfully with email: {}", request.getEmail());
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            logger.error("Error during signup for email: {}", request.getEmail(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during signup");
        }
    }

    @PostMapping("/login")  // Fixed URL mapping
    public ResponseEntity<AuthenticateResponse> authenticate(@RequestBody AuthenticateRequest authenticateRequest) {
        try {
            logger.info("Login request received for email: {}", authenticateRequest.getEmail());
            AuthenticateResponse response = authenticateService.authenticate(authenticateRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error during login for email: {}", authenticateRequest.getEmail(), e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
