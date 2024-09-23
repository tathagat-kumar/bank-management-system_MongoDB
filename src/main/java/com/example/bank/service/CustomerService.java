package com.example.bank.service;

import com.example.bank.model.Customer;

import java.util.List;


public interface CustomerService
{
    Customer saveCustomer(Customer customer, String userName);
    List<Customer> getAllCustomer();
}
