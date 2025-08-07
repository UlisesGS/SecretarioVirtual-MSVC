package com.example.service_dateEntity.service.impl;

import com.example.service_dateEntity.mappers.DateMapper;
import com.example.service_dateEntity.model.DateEntity;
import com.example.service_dateEntity.model.dtos.RequestCreateDateDto;
import com.example.service_dateEntity.model.dtos.ResponseDateDto;
import com.example.service_dateEntity.model.enums.DateState;
import com.example.service_dateEntity.repository.DateRepository;
import com.example.service_dateEntity.service.DateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DateServiceImpl implements DateService {

    private final DateRepository dateRepository;
    private final DateMapper dateMapper;

    @Override
    public ResponseDateDto createDate(RequestCreateDateDto createDateDto) {
        DateEntity dateEntity=dateMapper.requestCreateToDateEntity(createDateDto);
        dateEntity.setDuration(1);
        dateEntity.setState(DateState.LIBRE);
        dateEntity=dateRepository.save(dateEntity);
        return dateMapper.entityToDateDto(dateEntity);
    }

    @Override
    public List<ResponseDateDto> getAll() {
        List<DateEntity> dateEntityList=dateRepository.findAll();
        return dateMapper.listEntityToListDto(dateEntityList);
    }
}
