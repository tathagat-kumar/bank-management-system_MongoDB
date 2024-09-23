package com.example.bank.controller;

import com.example.bank.model.User;
import com.example.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUser()
    {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }
}
