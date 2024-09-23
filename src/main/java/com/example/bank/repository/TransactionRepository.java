package com.example.bank.repository;

import com.example.bank.model.Transaction;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface TransactionRepository extends MongoRepository<Transaction, ObjectId>
{

}
