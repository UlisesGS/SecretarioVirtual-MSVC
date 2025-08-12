package com.example.service_userEntity.exception;

public record ErrorResponse(
        int statusCode,
        String message
) {
}
