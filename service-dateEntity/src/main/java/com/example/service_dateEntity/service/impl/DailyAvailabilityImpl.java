package com.example.service_dateEntity.service.impl;


import com.example.service_dateEntity.mappers.DailyAvailabilityMapper;
import com.example.service_dateEntity.model.DailyAvailability;
import com.example.service_dateEntity.model.dtos.RequestCreateAvailabilityDto;
import com.example.service_dateEntity.model.dtos.ResponseDailyAvailabilityDto;
import com.example.service_dateEntity.repository.DailyAvailabilityRepository;
import com.example.service_dateEntity.service.DailyAvailabiltyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyAvailabilityImpl implements DailyAvailabiltyService {
    private final DailyAvailabilityRepository availabilityRepository;
    private final DailyAvailabilityMapper availabilityMapper;

    @Override
    public ResponseDailyAvailabilityDto create(RequestCreateAvailabilityDto createAvailabilityDto) {
        DailyAvailability dailyAvailability=availabilityMapper
                .requestCreateAvailabilityToDailyAvailability(createAvailabilityDto);

        dailyAvailability= availabilityRepository.save(dailyAvailability);
        System.out.println(dailyAvailability);
        System.out.println(availabilityMapper.dailyAvailabilityToDailyAvailabilityDto(dailyAvailability));
        return availabilityMapper.dailyAvailabilityToDailyAvailabilityDto(dailyAvailability);
    }

    @Override
    public List<ResponseDailyAvailabilityDto> getAll() {
        List<DailyAvailability>dailyAvailabilities=availabilityRepository.findAll();
        return availabilityMapper.dailyAvailabilityListToDailyAvailabilityDtoList(dailyAvailabilities);
    }
}
