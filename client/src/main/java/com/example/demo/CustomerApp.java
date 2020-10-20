package com.example.demo;

import com.example.demo.MainClasses.Customer.Customer;
import com.example.demo.MainClasses.Director.Director;
import com.example.demo.Methods.CustomerMethod;
import com.example.demo.Methods.DirectorMethod;
import com.example.demo.Methods.OrderMethod;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerApp
{
    public  static void main(String[] args)
    {
        CustomerMethod cusMeth = new CustomerMethod();
        DirectorMethod dirMeth = new DirectorMethod();
        OrderMethod orderMeth = new OrderMethod();

        Customer customer = cusMeth.createCustomer();
        Director director = dirMeth.createDirector();
        //System.out.println("Director wood amount is "+director.getWoodAmount());


        orderMeth.createOrder(director, customer);
        dirMeth.directorReport();
      //  dirMeth.directorReport();
       /* orderMeth.createOrder("Mei", 75);

        dirMeth.directorReport();
        SCMethod.SCReport();*/

        /*orderMeth.getOrderByStatus(OrderStatus.isAccepted);
        orderMeth.deleteOrderByStatus(OrderStatus.isAccepted);*/
    }
}
