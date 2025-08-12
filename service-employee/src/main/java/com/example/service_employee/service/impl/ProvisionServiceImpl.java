package com.example.service_employee.service.impl;

import com.example.service_employee.mappers.ProvisionMapper;
import com.example.service_employee.model.Provision;
import com.example.service_employee.model.dtos.RequestCreateProvisionDto;
import com.example.service_employee.model.dtos.ResponseProvisionDto;
import com.example.service_employee.repository.ProvisionRepository;
import com.example.service_employee.service.ProvisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProvisionServiceImpl implements ProvisionService {
    private final ProvisionRepository provisionRepository;
    private final ProvisionMapper provisionMapper;

    @Override
    public ResponseProvisionDto createProvision(RequestCreateProvisionDto provisionDto) {
        Provision provision= provisionMapper.createProvisionToProvision(provisionDto);
        provision=provisionRepository.save(provision);
        return provisionMapper.provisionToResponseProvisionDto(provision);
    }

    @Override
    public List<ResponseProvisionDto> getAll() {
        return provisionMapper.provisionListToProvisionResponseDto(provisionRepository.findAll());
    }
}
