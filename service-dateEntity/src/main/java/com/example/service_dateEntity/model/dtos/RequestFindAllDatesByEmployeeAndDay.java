package com.example.service_dateEntity.model.dtos;

import com.example.service_dateEntity.model.enums.DaysOfTheWeek;

public record RequestFindAllDatesByEmployeeAndDay(
        DaysOfTheWeek dayOfTheWeek,
        String employeeId
) {
}
