package com.example.service_userEntity.mappers;

import com.example.service_userEntity.model.UserEntity;
import com.example.service_userEntity.model.dtos.UserEntityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    UserEntity userDtoToUserEntity(UserEntityDto userEntityDto);
    UserEntityDto userEntityToUserDto(UserEntity userEntity);
    List<UserEntityDto> userEntityListToUserDtoList(List<UserEntity> userList);
    List<UserEntity> UserDtoListToUserEntityList(List<UserEntityDto> userDtoList);
}
