package com.example.service_userEntity.model.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RequestLoginDto(
        @NotBlank(message = "El email es obligatorio")
        @Email(message = "El formato de email es invalido")
        String email,
        @NotBlank
        String password
) {
}
