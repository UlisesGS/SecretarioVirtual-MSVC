package com.example.service_userEntity.model.dtos;

import com.example.service_userEntity.model.enums.Role;

import java.time.LocalDate;

public record ResponseRegisterDto(
        String id,
        String name,
        String surname,
        String email,
        LocalDate birthdate,
        Integer dni,
        Role role
) {
}
