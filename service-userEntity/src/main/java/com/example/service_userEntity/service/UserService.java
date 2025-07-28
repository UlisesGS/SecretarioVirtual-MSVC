package com.example.service_userEntity.service;

import com.example.service_userEntity.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserEntity create(UserEntity userEntity);

    List<UserEntity> listAll();

}
