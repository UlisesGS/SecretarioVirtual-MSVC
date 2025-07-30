package com.example.service_security.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JwtException extends RuntimeException {
    private String message;
}
