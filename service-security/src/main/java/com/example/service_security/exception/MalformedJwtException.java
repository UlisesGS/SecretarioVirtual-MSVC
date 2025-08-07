package com.example.service_security.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MalformedJwtException extends RuntimeException {
    private String message;
}
