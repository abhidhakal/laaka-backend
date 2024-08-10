package com.example.workshop.service;

import com.example.workshop.dto.AuthenticateRequest;
import com.example.workshop.dto.AuthenticateResponse;

public interface AuthenticateService {
    AuthenticateResponse authenticate(AuthenticateRequest authenticateRequest);
}
