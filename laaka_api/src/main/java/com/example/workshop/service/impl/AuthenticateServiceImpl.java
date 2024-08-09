package com.example.workshop.service.impl;

import com.example.workshop.dto.AuthenticateResponse;
import com.example.workshop.dto.LoginRequest;
import com.example.workshop.entity.User;
import com.example.workshop.repository.UserRepository;
import com.example.workshop.security.JwtService;
import com.example.workshop.service.AuthenticateService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticateServiceImpl implements AuthenticateService {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticateServiceImpl.class);
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;

    @Override
    public AuthenticateResponse authenticate(LoginRequest request) {
        logger.info("Attempting authentication for user: {}", request.getEmail());
        try {
            Optional<User> user = userRepository.findByEmail(request.getEmail());

            logger.info("User found, attempting to authenticate");
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user, request.getPassword())
            );

            logger.info("Authentication successful, generating token");
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String jwtToken = jwtService.generateToken(userDetails);

            logger.info("Token generated successfully");
            return new AuthenticateResponse(jwtToken);
        } catch (Exception e) {
            logger.error("Authentication failed for user: {}", request.getEmail(), e);
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials", e);
        }
    }
}
