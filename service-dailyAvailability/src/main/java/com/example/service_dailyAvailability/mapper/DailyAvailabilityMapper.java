package com.example.service_dailyAvailability.mapper;

import com.example.service_dailyAvailability.model.DailyAvailability;
import com.example.service_dailyAvailability.model.dtos.RequestCreateAvailabilityDto;
import com.example.service_dailyAvailability.model.dtos.ResponseDailyAvailabilityDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DailyAvailabilityMapper {
    DailyAvailability requestCreateAvailabilityToDailyAvailability(RequestCreateAvailabilityDto availabilityDto);
    ResponseDailyAvailabilityDto dailyAvailabilityToDailyAvailabilityDto(DailyAvailability dailyAvailability);
    List<ResponseDailyAvailabilityDto> dailyAvailabilityListToDailyAvailabilityDtoList
            (List<DailyAvailability> dailyAvailabilityList);
}
