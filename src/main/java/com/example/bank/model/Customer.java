package com.example.bank.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor

public class Customer
{
    @Id
    private String id;
    private String name;
    private  String lastName;
    private double balance;
    private Address address;
}
