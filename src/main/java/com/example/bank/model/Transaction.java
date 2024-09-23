package com.example.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor

public class Transaction
{
    @Id
    private ObjectId id;

    @NonNull
    private ObjectId source;

    @NonNull
    private  ObjectId target;

    private double amount;

    private LocalDateTime date;
}
