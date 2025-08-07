package com.example.service_dateEntity.service;

import com.example.service_dateEntity.model.dtos.RequestCreateDateDto;
import com.example.service_dateEntity.model.dtos.ResponseDateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DateService {

    ResponseDateDto createDate(RequestCreateDateDto createDateDto);

    List<ResponseDateDto> getAll();
}
