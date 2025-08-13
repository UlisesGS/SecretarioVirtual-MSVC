package com.example.service_userEntity.service.impl;

import com.example.service_userEntity.exception.ResourceAlreadyExistsException;
import com.example.service_userEntity.exception.ResourceNotFoundException;
import com.example.service_userEntity.mappers.UserMapper;
import com.example.service_userEntity.model.UserEntity;
import com.example.service_userEntity.model.dtos.*;
import com.example.service_userEntity.repository.UserRepository;
import com.example.service_userEntity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public ResponseCredentialsDto getCredentials(String email) {
        System.out.println(email);
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "Usuario con email: " + email + " no encontrado"
                ));
        System.out.println(userEntity);
        ResponseCredentialsDto credentialsDto=userMapper.userEntityToResponseCredentialsDto(userEntity);
        System.out.println(credentialsDto);
        return credentialsDto;
    }

    @Override
    public ResponseRegisterDto create(RequestRegisterDto requestRegisterDto) {

        if (userRepository.findByEmail(requestRegisterDto.email()).isPresent()){
            throw new ResourceAlreadyExistsException("Ya hay una cuenta asociada con el email " + requestRegisterDto.email() + ".");
        }

        UserEntity userEntity= userMapper.registerDtoToUserEntity(requestRegisterDto);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
        return userMapper.userEntityToResponseRegister(userEntity);
    }

    @Override
    public List<ResponseUserDto> listAll() {
        List<UserEntity> userList = userRepository.findAll();

        if (userList.isEmpty()){
            throw new ResourceNotFoundException("No hay datos guardados");
        }

        return userMapper.userEntityListToResponseList(userList);
    }

    @Override
    public ResponseUserDto findById(String id) {
        UserEntity userEntity= userRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Usuario con id: "+ id + " no encontrado"));
        ResponseUserDto userDto=userMapper.userEntityToResponseUserDto(userEntity);
        return  userDto;
    }

}
