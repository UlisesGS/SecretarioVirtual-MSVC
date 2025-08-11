package com.example.service_dateEntity.model.dtos;

import com.example.service_dateEntity.model.enums.DaysOfTheWeek;

import java.time.LocalDateTime;

public record ResponseDailyAvailabilityDto(
        String id,
        String employeeId,
        DaysOfTheWeek dayOfTheWeek

) {
}
