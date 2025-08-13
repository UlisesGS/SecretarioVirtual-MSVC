package com.example.service_dateEntity.mappers;



import com.example.service_dateEntity.model.DailyAvailability;
import com.example.service_dateEntity.model.dtos.RequestCreateAvailabilityDto;
import com.example.service_dateEntity.model.dtos.ResponseDailyAvailabilityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DailyAvailabilityMapper {

    DailyAvailability requestCreateAvailabilityToDailyAvailability(RequestCreateAvailabilityDto availabilityDto);

    ResponseDailyAvailabilityDto dailyAvailabilityToDailyAvailabilityDto(DailyAvailability dailyAvailability);

    List<ResponseDailyAvailabilityDto> dailyAvailabilityListToDailyAvailabilityDtoList
            (List<DailyAvailability> dailyAvailabilityList);
}
