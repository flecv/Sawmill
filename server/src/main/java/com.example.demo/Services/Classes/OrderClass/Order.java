package com.example.demo.Services.Classes.OrderClass;

import com.example.demo.Services.Classes.CustomerClass.Customer;
import com.example.demo.Services.Classes.DirectorClass.Director;


public class Order
{
    private int request;
    private Customer customer;
    private Director director;
    private OrderStatus status = OrderStatus.isPreparing;

    public Order(String directorName, int woodAmount, int balance, String customerName, int customerAge, int customerRequest) {
    }

    public Order(int request) {
        this.request = request;
    }

    public int getRequest() {
        return request;
    }

    public void setRequest(int request) {
        this.request = request;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
