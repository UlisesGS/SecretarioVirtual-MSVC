package com.example.service_userEntity.service;

import com.example.service_userEntity.model.dtos.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    ResponseCredentialsDto getCredentials(String email);

    ResponseRegisterDto create(RequestRegisterDto user);

    List<ResponseUserDto> listAll();

    ResponseUserDto findById(String id);



}
