package com.example.service_userEntity.service;

import com.example.service_userEntity.model.UserEntity;
import com.example.service_userEntity.repositoy.IUserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    private List<UserEntity> userList=new ArrayList<>();

    @PostConstruct
    public void initUsers() {
        userRepository.save(new UserEntity("1", "Daniel", "daniel@example.com", "user123"));
        userRepository.save(new UserEntity("2", "Ulises", "ulises@example.com", "user123"));
    }
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(String id){
        return userRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException ("User with id: " + id + " not found"));
    }



}
