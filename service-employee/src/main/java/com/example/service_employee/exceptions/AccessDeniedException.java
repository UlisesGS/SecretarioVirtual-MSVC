package com.example.service_employee.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccessDeniedException extends RuntimeException {
    private String message;
}