package com.example.service_dateEntity.mappers;



import com.example.service_dateEntity.model.DailyAvailability;
import com.example.service_dateEntity.model.dtos.RequestCreateAvailabilityDto;
import com.example.service_dateEntity.model.dtos.ResponseDailyAvailabilityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DailyAvailabilityMapper {
    @Mapping(source = "dayOfTheWeek", target = "dayOfTheWeek")
    DailyAvailability requestCreateAvailabilityToDailyAvailability(RequestCreateAvailabilityDto availabilityDto);
    @Mapping(source = "dayOfTheWeek", target = "dayOfTheWeek")
    ResponseDailyAvailabilityDto dailyAvailabilityToDailyAvailabilityDto(DailyAvailability dailyAvailability);
    @Mapping(source = "dayOfTheWeek", target = "dayOfTheWeek")
    List<ResponseDailyAvailabilityDto> dailyAvailabilityListToDailyAvailabilityDtoList
            (List<DailyAvailability> dailyAvailabilityList);
}
