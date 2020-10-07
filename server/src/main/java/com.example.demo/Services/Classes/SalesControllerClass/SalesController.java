package com.example.demo.Services.Classes.SalesControllerClass;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@EnableAutoConfiguration
public class SalesController {

    @Id
    private UUID id;
    private String name;
    private int balance;

    public SalesController()
    {

    }

    public SalesController(String name, int balance) {
        this.name = name;
        id=UUID.randomUUID();
        this.balance=balance;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance()
    {
        return balance;
    }
    public void setBalance(int balance)
    {
        this.balance = balance;
    }

    @Override
    public String toString()
    {
        return "Sales controller name is "+name+". Balance is "+balance+".";
    }
}
