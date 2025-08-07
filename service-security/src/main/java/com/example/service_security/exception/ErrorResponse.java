package com.example.service_security.exception;

public record ErrorResponse(
        int statusCode,
        String message
) {}
