package com.example.service_security.exception;

import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public class InvalidUserCredentialsException extends RuntimeException {
    public InvalidUserCredentialsException() {
        super();
    }

    public InvalidUserCredentialsException(String message) {
        super(message);
    }

    public InvalidUserCredentialsException(String s, FeignException e) {
    }
}
