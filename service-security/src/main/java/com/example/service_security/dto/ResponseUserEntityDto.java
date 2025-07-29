package com.example.service_security.dto;

public record ResponseUserEntityDto(
        String id,
        String email,
        String name,
        String role
) {}
