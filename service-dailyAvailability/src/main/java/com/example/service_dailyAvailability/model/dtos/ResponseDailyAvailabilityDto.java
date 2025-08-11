package com.example.service_dailyAvailability.model.dtos;

import java.time.LocalDateTime;

public record ResponseDailyAvailabilityDto(
        String id,
        String employeeId,
        LocalDateTime dateTime
) {
}
