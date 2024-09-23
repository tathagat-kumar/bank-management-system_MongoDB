package com.example.bank.service;

import com.example.bank.model.Transaction;
import org.bson.types.ObjectId;

import java.util.List;


public interface TransactionService
{
    Transaction saveTransaction(Transaction transaction);
    List<Transaction> getAllTransaction();
}
