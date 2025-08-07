package com.example.service_dateEntity.model.dtos;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RequestCreateDateDto(
        @NotNull(message = "horario de inicio invalido")
        LocalDateTime startTime,
        @NotNull(message = "horario de fin invalido")
        LocalDateTime endTime,
        @Email(message = "email invalido")
        String emailEmployee
) {
}
