package com.example.bank.service.impl;

import com.example.bank.model.Customer;
import com.example.bank.model.Transaction;
import com.example.bank.repository.CustomerRepository;
import com.example.bank.repository.TransactionRepository;
import com.example.bank.service.TransactionService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService
{
    private static final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Transaction saveTransaction(Transaction transaction)
    {
        Customer srcCustomer = customerRepository.findById(transaction.getSource()).orElse(null);
        Customer targetCustomer = customerRepository.findById(transaction.getTarget()).orElse(null);

        if(srcCustomer != null && targetCustomer != null)
        {
            double sourceBal = srcCustomer.getBalance();
            double targetBal = targetCustomer.getBalance();
            double tranAmount = transaction.getAmount();

            if (sourceBal >= tranAmount)
            {
                sourceBal = sourceBal - tranAmount;
                targetBal = targetBal + tranAmount;
            }
            else
            {
                log.error("Insufficient Balance!");
            }

            srcCustomer.setBalance(sourceBal);
            targetCustomer.setBalance(targetBal);
            customerRepository.save(srcCustomer);
            customerRepository.save(targetCustomer);
        }
        else
        {
            log.error("Transaction cannot be processed!");
        }
        transaction.setDate(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransaction()
    {
        return transactionRepository.findAll();
    }
}
