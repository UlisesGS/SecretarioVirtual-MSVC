package com.example.service_employee.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResourceNotFoundException  extends RuntimeException{
    private String message;
}
