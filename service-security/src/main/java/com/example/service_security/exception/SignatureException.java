package com.example.service_security.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SignatureException extends RuntimeException {
    private String message;
}
