package com.example.bank.service;

import com.example.bank.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService
{
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomer();
}
