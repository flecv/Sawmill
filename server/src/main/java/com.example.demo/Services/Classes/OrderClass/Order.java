package com.example.demo.Services.Classes.OrderClass;

import com.example.demo.Services.Classes.SalesControllerClass.SalesController;
import com.example.demo.Services.Classes.CustomerClass.Customer;
import com.example.demo.Services.Classes.DirectorClass.Director;


public class Order
{
    private int request;
    private Customer customer;
    private Director director;
    private SalesController salesController;
    private OrderStatus status = OrderStatus.isPreparing;

    public Order() {
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

    public SalesController getSalesController() {
        return salesController;
    }

    public void setSalesController(SalesController salesController) {
        this.salesController = salesController;
    }
}
