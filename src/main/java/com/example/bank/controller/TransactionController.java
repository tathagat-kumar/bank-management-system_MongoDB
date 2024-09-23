package com.example.bank.controller;

import com.example.bank.model.Transaction;
import com.example.bank.model.User;
import com.example.bank.service.TransactionService;
import com.example.bank.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController
{
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/getAllTrans")
    public ResponseEntity<List<Transaction>> getAllTrans()
    {
        return new ResponseEntity<>(transactionService.getAllTransaction(), HttpStatus.OK);
    }

    @PostMapping("/saveTrans")
    public ResponseEntity<Transaction> createTrans(@RequestBody Transaction transaction)
    {
        return new ResponseEntity<Transaction>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
    }
}
