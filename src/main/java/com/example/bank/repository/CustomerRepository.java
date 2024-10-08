package com.example.bank.repository;

import com.example.bank.model.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository extends MongoRepository<Customer, ObjectId>
{

}
