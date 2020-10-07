package com.example.demo.MainClasses.Customer;

public class Customer {
    private String name;
    private int age;
    private int request;


    public Customer() {
    }

    public Customer(String name, int age, int request) {
        this.name = name;
        this.age = age;
        this.request = request;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRequest() {
        return request;
    }

    public void setRequest(int request) {
        this.request = request;
    }

    @Override
    public String toString()
    {
        return "Customer name is "+name+". Age is "+age+". Request is "+request+".";
    }
}
