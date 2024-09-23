package com.example.bank.service.impl;

import com.example.bank.model.Customer;
import com.example.bank.model.User;
import com.example.bank.repository.UserRepository;
import com.example.bank.service.CustomerService;
import com.example.bank.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user)
    {
        //user.setDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }
}
