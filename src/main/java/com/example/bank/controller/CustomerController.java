package com.example.bank.controller;

import com.example.bank.model.Customer;
import com.example.bank.model.User;
import com.example.bank.service.CustomerService;
import com.example.bank.service.UserService;
import com.example.bank.service.impl.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController
{

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/createCustomer/{userName}")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer,@PathVariable String userName)
    {
        User user = userService.findByUserName(userName);
        Customer savedCustomer = customerService.saveCustomer(customer,userName);
        user.getCustomerList().add(savedCustomer);
        userService.saveUser(user);
        log.info("Customer created successfully!");
        return new ResponseEntity<Customer>(customerService.saveCustomer(customer,userName), HttpStatus.CREATED);
    }

    @GetMapping("/getAllCustomer/{userName}")
    public ResponseEntity<List<Customer>> getAllCustomer(@PathVariable String userName)
    {
        User user = userService.findByUserName(userName);
        List<Customer> customerList = user.getCustomerList();
        return new ResponseEntity<List<Customer>>(customerList,HttpStatus.OK);
    }
}
