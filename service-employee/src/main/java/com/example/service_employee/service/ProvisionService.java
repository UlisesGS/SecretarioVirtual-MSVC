package com.example.service_employee.service;

import com.example.service_employee.model.dtos.RequestCreateProvisionDto;
import com.example.service_employee.model.dtos.ResponseProvisionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProvisionService {
    ResponseProvisionDto createProvision(RequestCreateProvisionDto provisionDto);
    List<ResponseProvisionDto>getAll();
}
