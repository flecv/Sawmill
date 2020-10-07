package com.example.demo.MainClasses.SalesController;

import java.util.UUID;

public class SalesController {
    private UUID id;
    private String name;
    private int balance;

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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    @Override
    public String toString()
    {
        return "Sales controller name is "+name+". Balance is "+balance+".";
    }
}
