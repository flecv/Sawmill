package com.example.demo.Services.ServiceRealisation.OrderService;

import com.example.demo.Services.Classes.CustomerClass.Customer;
import com.example.demo.Services.Classes.OrderClass.Order;
import com.example.demo.Services.Classes.OrderClass.OrderStatus;
import com.example.demo.Services.Classes.DirectorClass.Director;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    public Order createOrder(int amount)
    {
        return new Order(amount);
    }

    public void setCustomer(Order order, Customer customer)
    {
        order.setCustomer(customer);
    }


    public Order decisionMaking(Director director, Customer customer)
    {
        Order order = createOrder(customer.getRequest());
        if (director.getWoodAmount() < customer.getRequest())
        {
            System.out.println("In decision making, rejected version");
            order.setStatus(OrderStatus.isRejected);

            return order;
        }
        else
        {
            System.out.println("In decision making, accepted version");
            order.setStatus(OrderStatus.isAccepted);
            return order;
        }
    }
    public boolean checkIfIsCompleted(Order order) {
        return order.getStatus() == OrderStatus.isAccepted;
    }

}
