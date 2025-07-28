package com.example.service_userEntity.service;

import com.example.service_userEntity.model.UserEntity;
import com.example.service_userEntity.model.dtos.UserEntityDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserEntityDto create(UserEntityDto user);

    List<UserEntityDto> listAll();

}
