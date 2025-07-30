package com.example.service_userEntity.model.dtos;

import com.example.service_userEntity.model.enums.Role;

import java.time.LocalDate;

public record ResponseRegisterDto(
        String id,
        String username,
        String email,
        LocalDate birthdate,
        int dni,
        Role role
) {
}
