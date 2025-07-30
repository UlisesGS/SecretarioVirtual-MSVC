package com.example.service_userEntity.service.impl;

import com.example.service_userEntity.mappers.UserMapper;
import com.example.service_userEntity.model.UserEntity;
import com.example.service_userEntity.model.dtos.UserEntityDto;
import com.example.service_userEntity.repositoy.UserRepository;
import com.example.service_userEntity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override
    public UserEntityDto create(UserEntityDto user) {
        UserEntity userEntity= userMapper.userDtoToUserEntity(user);
        userEntity=userRepository.save(userEntity);
        user=userMapper.userEntityToUserDto(userEntity);
        return user;
    }

    @Override
    public List<UserEntityDto> listAll() {
        List<UserEntity> userList = userRepository.findAll();
        return userMapper.userEntityListToUserDtoList(userList);
    }
}
