package com.example.workshop.service.impl;

import com.example.workshop.dto.AuthenticateResponse;
import com.example.workshop.dto.LoginRequest;
import com.example.workshop.repository.UserRepository;
import com.example.workshop.security.JwtService;
import com.example.workshop.service.AuthenticateService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
@RequiredArgsConstructor
public class AuthenticateServiceImpl implements AuthenticateService {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticateService.class);
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;

    public AuthenticateResponse authenticate(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        UserDetails user = (UserDetails) authentication.getPrincipal();
        String jwtToken = jwtService.generateToken(user);
        logger.info("Authentication successful for user: {}", request.getUsername());
        return new AuthenticateResponse(jwtToken);
    }
}
