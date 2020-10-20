package com.example.demo.Controllers;


import com.example.demo.Services.Classes.DirectorClass.Director;
import com.example.demo.Services.Classes.OrderClass.Order;
import com.example.demo.Services.Classes.CustomerClass.Customer;
import com.example.demo.Services.Classes.OrderClass.OrderStatus;
import com.example.demo.Services.ServiceRealisation.CustomerService.CustomerService;
import com.example.demo.Services.ServiceRealisation.DirectorService.DirectorService;
import com.example.demo.Services.ServiceRealisation.OrderService.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping(value = "/order")
public class OrderController
{
    private final OrderService orderService;
    private final DirectorService directorService;
    private final CustomerService customerService;


    private void updateInformation(Order order, String customerName)
    {
        Director director = directorService.getDirector();
        Customer customer = customerService.getCustomerByName(customerName);
        if(order.getStatus()==OrderStatus.isAccepted)
        {
            System.out.println(customer.toString());
            System.out.println(director.toString());
            System.out.println("We can sell you this amount of wood");
            director.setWoodAmount(director.getWoodAmount() - customer.getRequest());
            director.setBalance(director.getBalance() + 10 * customer.getRequest());

            order.setDirector(director);
            directorService.updateDirectorInformation(director);
            order.setStatus(OrderStatus.isAccepted);
        }
        else
        {
            System.out.println("We can not sell you this amount of wood.");
            order.setStatus(OrderStatus.isRejected);
            System.out.println(customer.toString());
            System.out.println(director.toString());
            directorService.woodControl(director, customer.getRequest());
            order.setDirector(director);
            directorService.updateDirectorInformation(director);
            System.out.println(director.toString());
        }
    }

    @Autowired
    public OrderController(OrderService orderService, DirectorService directorService, CustomerService customerService)
    {
        this.orderService=orderService;
        this.customerService = customerService;
        this.directorService=directorService;
    }
    @PostMapping
    public ResponseEntity<Boolean> processing(@RequestParam String customerName, @RequestParam int customerAge, @RequestParam int customerRequest)
    {
        Customer customer = customerService.createCustomer(customerName,customerAge,customerRequest);
        Director director = directorService.getDirector();
        Order order = orderService.decisionMaking(director, customer);

        orderService.setCustomer(order, customer);
        updateInformation(order,customer.getName());
        return ResponseEntity.ok(orderService.checkIfIsCompleted(order));
    }
    /*@GetMapping
    public ResponseEntity<Boolean> completing(@RequestParam String customerName, @RequestParam String directorName, @RequestParam int customerAge, @RequestParam int customerRequest)
    {
        Customer customer = customerService.createCustomer(customerName, customerAge, customerRequest);
        Order order = orderService.decisionMaking()
        orderService.setCustomer(order, customer);
        updateInformation(order, director, customer);

        return ResponseEntity.ok(orderService.checkIfIsCompleted(order));
    }
*/
}
