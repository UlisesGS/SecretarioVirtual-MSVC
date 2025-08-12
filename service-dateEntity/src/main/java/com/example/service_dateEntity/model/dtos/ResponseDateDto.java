package com.example.service_dateEntity.model.dtos;

import com.example.service_dateEntity.model.enums.DateState;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ResponseDateDto(
        String id,
        Integer duration,
        LocalDateTime startTime,
        LocalDateTime endTime,
        DateState state,
        boolean fixed,
        String dailyAvailabilityId
) {
}
