package com.example.service_userEntity.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResourceNotFoundException  extends RuntimeException{
    private String message;
}