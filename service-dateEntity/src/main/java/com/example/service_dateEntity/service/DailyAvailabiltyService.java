package com.example.service_dateEntity.service;


import com.example.service_dateEntity.model.dtos.RequestCreateAvailabilityDto;
import com.example.service_dateEntity.model.dtos.ResponseDailyAvailabilityDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DailyAvailabiltyService {
    ResponseDailyAvailabilityDto create(RequestCreateAvailabilityDto createAvailabilityDto);
    List<ResponseDailyAvailabilityDto>getAll();
}
