package com.example.service_dailyAvailability.service.impl;

import com.example.service_dailyAvailability.mapper.DailyAvailabilityMapper;
import com.example.service_dailyAvailability.model.DailyAvailability;
import com.example.service_dailyAvailability.model.dtos.RequestCreateAvailabilityDto;
import com.example.service_dailyAvailability.model.dtos.ResponseDailyAvailabilityDto;
import com.example.service_dailyAvailability.repository.DailyAvailabilityRepository;
import com.example.service_dailyAvailability.service.DailyAvailabiltyService;
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

        return availabilityMapper.dailyAvailabilityToDailyAvailabilityDto(dailyAvailability);
    }

    @Override
    public List<ResponseDailyAvailabilityDto> getAll() {
        List<DailyAvailability>dailyAvailabilities=availabilityRepository.findAll();
        return availabilityMapper.dailyAvailabilityListToDailyAvailabilityDtoList(dailyAvailabilities);
    }
}
