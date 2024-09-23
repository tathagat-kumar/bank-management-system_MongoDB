package com.example.bank.repository;

import com.example.bank.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId>
{
    User findByUserName(String username);
}
