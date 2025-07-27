package com.example.service_userEntity.service.impl;

import com.example.service_userEntity.model.UserEntity;
import com.example.service_userEntity.repositoy.UserRepository;
import com.example.service_userEntity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserEntity create(UserEntity userEntity) {
        userRepository.save(userEntity);
        return userEntity;
    }

    @Override
    public List<UserEntity> listAll() {
        List<UserEntity> userList = userRepository.findAll();
        return userList;
    }
}
