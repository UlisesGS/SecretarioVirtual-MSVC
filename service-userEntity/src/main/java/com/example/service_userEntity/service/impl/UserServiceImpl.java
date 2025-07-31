package com.example.service_userEntity.service.impl;

import com.example.service_userEntity.mappers.UserMapper;
import com.example.service_userEntity.model.UserEntity;
import com.example.service_userEntity.model.dtos.*;
import com.example.service_userEntity.repositoy.UserRepository;
import com.example.service_userEntity.service.UserService;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

//    @Override
//    public ResponseLoginDto login(RequestLoginDto requestLoginDto) {
//        UserEntity userEntity = userRepository.findByEmail(requestLoginDto.email())
//                .orElseThrow(()-> new UsernameNotFoundException(
//                        "Usuario con email: " + requestLoginDto.email() + " no encontrado"
//                ));
//        if (userEntity.getPassword().equals(requestLoginDto.password())){
//            return new ResponseLoginDto(userEntity.getId(),"token");
//        }else {
//            throw new BadCredentialsException("Contraseña incorrecta");
//        }
//    }

    @Override
    public ResponseCredentialsDto getCredentials(String email) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(()-> new NoSuchElementException(
                        "Usuario con email: " + email + " no encontrado"
                ));
        ResponseCredentialsDto credentialsDto=userMapper.userEntityToResponseCredentialsDto(userEntity);

        return credentialsDto;
    }

    @Override
    public ResponseRegisterDto create(RequestRegisterDto user) {
        UserEntity userEntity= userMapper.registerDtoToUserEntity(user);
        userEntity=userRepository.save(userEntity);
        ResponseRegisterDto responseRegisterDto =userMapper.userEntityToResponseRegister(userEntity);
        return responseRegisterDto;
    }

    @Override
    public List<ResponseUserDto> listAll() {
        List<UserEntity> userList = userRepository.findAll();
        List<ResponseUserDto>responseList=userMapper.userEntityListToResponseList(userList);
        return  responseList;
    }

    @Override
    public ResponseUserDto findById(String id) {
        UserEntity userEntity= userRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Usuario con id: "+ id + " no encontrado"));
        ResponseUserDto userDto=userMapper.userEntityToResponseUserDto(userEntity);
        return  userDto;
    }

}
