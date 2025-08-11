package com.example.service_dateEntity.model.dtos;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RequestCreateDateDto(
        @NotNull(message = "numero invalido")
        Integer duration,
        @NotNull(message = "horario de inicio invalido")
        LocalDateTime startTime,
        @NotBlank(message = "id de empleado invalido")
        String dailyAvailabilityId,
        @NotNull(message = "fijo debe tener un valor")
        boolean fixed
) {
}
