package com.example.service_dateEntity.mappers;

import com.example.service_dateEntity.model.DateEntity;
import com.example.service_dateEntity.model.dtos.RequestCreateDateDto;
import com.example.service_dateEntity.model.dtos.ResponseDateDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = DailyMapper.class)
public interface DateMapper {
    DateEntity requestCreateToDateEntity(RequestCreateDateDto createDateDto);
    ResponseDateDto entityToDateDto(DateEntity dateEntity);
    List<ResponseDateDto>listEntityToListDto(List<DateEntity> dateEntityList);
}
