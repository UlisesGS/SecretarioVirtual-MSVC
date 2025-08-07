package com.example.service_employee.exceptions;

public record ErrorResponse(
        int statusCode,
        String message
) {
}
