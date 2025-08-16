package com.example.service_dateEntity.model.dtos;

import java.time.LocalDate;

public record RequestFindAllByDayAndEmployeeAndDate(
        String dayOfTheWeek,
        String employeeId,
        LocalDate dateOfMonth
) {
}
