package com.example.service_userEntity.mappers;

import com.example.service_userEntity.model.UserEntity;
import com.example.service_userEntity.model.dtos.RequestRegisterDto;
import com.example.service_userEntity.model.dtos.ResponseCredentialsDto;
import com.example.service_userEntity.model.dtos.ResponseUserDto;
import com.example.service_userEntity.model.dtos.ResponseRegisterDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity registerDtoToUserEntity(RequestRegisterDto requestRegisterDto);
    ResponseRegisterDto userEntityToResponseRegister(UserEntity userEntity);
    ResponseCredentialsDto userEntityToResponseCredentialsDto(UserEntity userEntity);
    ResponseUserDto userEntityToResponseUserDto(UserEntity userEntity);
    List<ResponseUserDto>userEntityListToResponseList(List<UserEntity>userEntityList);

}
