package com.example.service_employee.model.dtos;

import com.example.service_employee.model.enums.Role;

public record ResponseCredentialsDto(
        String id,
        String email,
        String name,
        String surname,
        Role role,
        String password
) {
}
