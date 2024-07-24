package com.example.workshop.service;

import com.example.workshop.dto.AuthenticateResponse;
import com.example.workshop.dto.LoginRequest;

public interface AuthenticateService {
    AuthenticateResponse authenticate(LoginRequest authenticateRequest);
}
