package com.example.service_security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ResponseLoginDto (
        String accessToken,
        String refreshToken
){}
