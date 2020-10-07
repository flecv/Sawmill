package com.example.demo.MainClasses.Order;

import com.example.demo.MainClasses.Customer.Customer;
import com.example.demo.MainClasses.Director.Director;

public class Order {
    private Customer customer;
    private Director director;
    private OrderStatus status = OrderStatus.isPreparing;

    public Order()
    {

    }

    @Override
    public String toString()
    {
        return "Customer request is "+customer.getRequest();
    }


}
