package com.example.service_dailyAvailability.service;

import com.example.service_dailyAvailability.model.dtos.RequestCreateAvailabilityDto;
import com.example.service_dailyAvailability.model.dtos.ResponseDailyAvailabilityDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DailyAvailabiltyService {
    ResponseDailyAvailabilityDto create(RequestCreateAvailabilityDto createAvailabilityDto);
    List<ResponseDailyAvailabilityDto>getAll();
}
