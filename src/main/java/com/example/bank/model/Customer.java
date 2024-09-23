package com.example.bank.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor

public class Customer
{
    @Id
    private ObjectId id;
    private String name;
    private  String lastName;
    private double balance;
    private Address address;
    private LocalDateTime date;
}
