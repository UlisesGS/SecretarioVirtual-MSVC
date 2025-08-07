package com.example.service_dateEntity.model.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ResponseDateDto(
        String id,
        Integer duration,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String emailEmployee
) {
}
