package com.example.service_userEntity.model.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record RequestRegisterDto(

        @NotBlank (message = "El username es obligatorio.")
        String username,
        @NotBlank(message = "El email es obligatorio.")
        @Email(message = "EL formato de email es invalido.")
        String email,
        @NotBlank(message = "El password es obligatorio.")
        String password,
        @Past(message = "Fecha invalida.")
        LocalDate birthdate,
        @NotNull(message = "El dni es obligatorio.")
        int dni
){
}
