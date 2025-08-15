package com.example.service_dateEntity.service;


import com.example.service_dateEntity.model.DateEntity;
import com.example.service_dateEntity.model.dtos.RequestCreateAvailabilityDto;
import com.example.service_dateEntity.model.dtos.RequestFindAllDatesByEmployeeAndDay;
import com.example.service_dateEntity.model.dtos.ResponseDailyAvailabilityDto;
import com.example.service_dateEntity.model.dtos.ResponseDateDto;
import com.example.service_dateEntity.model.enums.DaysOfTheWeek;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DailyAvailabiltyService {
    ResponseDailyAvailabilityDto create(RequestCreateAvailabilityDto createAvailabilityDto);
    List<ResponseDailyAvailabilityDto>getAll();
    List<ResponseDateDto> findAllByDayAndEmployee(RequestFindAllDatesByEmployeeAndDay request);
}
