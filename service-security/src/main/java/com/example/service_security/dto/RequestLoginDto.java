package com.example.service_security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record RequestLoginDto (
        @NotBlank(message = "El email es obligatorio y no puede estar vacío.")
        @Email(message = "Formato de email no válido.")
        String email,
        @NotBlank(message = "La contraseña es obligatoria.")
        String password
){}
