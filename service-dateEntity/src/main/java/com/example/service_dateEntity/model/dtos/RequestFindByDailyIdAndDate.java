package com.example.service_dateEntity.model.dtos;

import java.time.LocalDate;

public record RequestFindByDailyIdAndDate(
        String dailyId,
        LocalDate date
) {
}
