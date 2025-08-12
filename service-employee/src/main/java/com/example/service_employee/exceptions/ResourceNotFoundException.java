package com.example.service_employee.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
public class ResourceNotFoundException  extends RuntimeException {
    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}