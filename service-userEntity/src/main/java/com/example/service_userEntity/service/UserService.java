package com.example.service_userEntity.service;

import com.example.service_userEntity.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<UserEntity> userList=new ArrayList<>();

    public UserService(){
        userList.add(new UserEntity("1", "Daniel", "daniel@example.com","user123"));
        userList.add(new UserEntity("2", "Ulises", "ulises@example.com","user123"));
    }

    public List<UserEntity> getAllUsers() {
        return userList;
    }

    public UserEntity getUserById(String id){
        return userList.stream()
                .filter(user->user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public UserEntity createUser(UserEntity user) {
        userList.add(user);
        return userList.getLast();
    }

    public boolean removeUserById(String id) {
        return userList.removeIf(user -> user.getId().equals(id));
    }
}
