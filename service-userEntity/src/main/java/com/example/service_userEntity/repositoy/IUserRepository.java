package com.example.service_userEntity.repositoy;

import com.example.service_userEntity.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends MongoRepository<UserEntity,String> {
}
