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
    //Register
    UserEntity registerDtoToUserEntity(RequestRegisterDto requestRegisterDto);
    ResponseRegisterDto userEntityToResponseRegister(UserEntity userEntity);

    //auth
    ResponseCredentialsDto userEntityToResponseCredentialsDto(UserEntity userEntity);

    //List
    ResponseUserDto userEntityToResponseUserDto(UserEntity userEntity);
    List<ResponseUserDto>userEntityListToResponseList(List<UserEntity>userEntityList);

}
