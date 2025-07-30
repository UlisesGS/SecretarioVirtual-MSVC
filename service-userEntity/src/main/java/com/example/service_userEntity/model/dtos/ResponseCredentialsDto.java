package com.example.service_userEntity.model.dtos;

import com.example.service_userEntity.model.enums.Role;
import com.example.service_userEntity.model.enums.UserState;

import java.time.LocalDate;

public record ResponseCredentialsDto(
        String id,
        String email,
        String username,
        Role rol,
        String password
) {
}
