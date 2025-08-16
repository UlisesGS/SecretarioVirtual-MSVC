package com.example.service_dateEntity.service;


import com.example.service_dateEntity.model.dtos.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface DailyAvailabiltyService {
    ResponseDailyAvailabilityDto create(RequestCreateAvailabilityDto createAvailabilityDto);
    List<ResponseDailyAvailabilityDto>getAll();
    List<ResponseDateDto> findAllByDayAndEmployee(RequestFindAllDatesByEmployeeAndDay request);
    List<ResponseDateDto> createDatesByDaily(String dailyId);
    List<ResponseDateDto> findAllByDayAndEmployeeAndDate(RequestFindAllByDayAndEmployeeAndDate request);
}
