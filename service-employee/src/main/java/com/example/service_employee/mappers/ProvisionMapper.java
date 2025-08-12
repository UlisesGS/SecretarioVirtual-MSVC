package com.example.service_employee.mappers;

import com.example.service_employee.model.Provision;
import com.example.service_employee.model.dtos.RequestCreateProvisionDto;
import com.example.service_employee.model.dtos.ResponseProvisionDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProvisionMapper {
    Provision createProvisionToProvision(RequestCreateProvisionDto provisionDto);
    ResponseProvisionDto provisionToResponseProvisionDto(Provision provision);

    List<ResponseProvisionDto>provisionListToProvisionResponseDto(List<Provision>provisionList);

}
