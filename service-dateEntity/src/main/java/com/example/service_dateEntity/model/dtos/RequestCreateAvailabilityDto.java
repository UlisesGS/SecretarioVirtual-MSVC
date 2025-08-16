package com.example.service_dateEntity.model.dtos;

import com.example.service_dateEntity.model.enums.DaysOfTheWeek;

import java.util.List;

public record RequestCreateAvailabilityDto(
        String employeeId,
        DaysOfTheWeek dayOfTheWeek,
        Integer duration,
        List<Double> range,
        Integer rest
) {
}
