package com.example.service_dailyAvailability.model.dtos;

import java.time.LocalDateTime;

public record RequestCreateAvailabilityDto(
        String employeeId,
        LocalDateTime dateTime
) {
}
