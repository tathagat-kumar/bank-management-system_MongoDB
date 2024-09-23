package com.example.bank.service;

import com.example.bank.model.User;

import java.util.List;


public interface UserService
{
    User saveUser(User user);
    List<User> getAllUsers();
    public User findByUserName(String username);
}
