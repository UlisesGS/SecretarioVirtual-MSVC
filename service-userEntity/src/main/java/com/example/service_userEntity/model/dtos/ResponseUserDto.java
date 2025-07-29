package com.example.service_userEntity.model.dtos;

import com.example.service_userEntity.model.enums.UserState;

import java.time.LocalDate;

public record ResponseUserDto(
        String id,
        String username,
        String email,
        LocalDate birthdate,
        int dni,
        UserState state
) {
}
