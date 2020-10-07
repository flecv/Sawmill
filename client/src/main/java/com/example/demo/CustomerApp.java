package com.example.demo;

import com.example.demo.MainClasses.Director.Director;
import com.example.demo.MainClasses.Order.OrderStatus;
import com.example.demo.Methods.CustomerMethod;
import com.example.demo.Methods.DirectorMethod;
import com.example.demo.Methods.OrderMethod;
import com.example.demo.Methods.SCMethod;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerApp
{
    public  static void main(String[] args)
    {
        CustomerMethod cusMeth = new CustomerMethod();
        DirectorMethod dirMeth = new DirectorMethod();
        OrderMethod orderMeth = new OrderMethod();
        SCMethod SCMethod = new SCMethod();

     //   cusMeth.createCustomer();
        Director director = dirMeth.createDirector(100, 100);
        //System.out.println("Director wood amount is "+director.getWoodAmount());


        orderMeth.createOrder("Konrad", director.getWoodAmount(), director.getBalance(), "Miho", 30, 30);
        dirMeth.directorReport();
       /* SCMethod.SCReport();*/
        orderMeth.createOrder("Konrad", director.getWoodAmount(), director.getBalance(), "Naomi", 40, 100);
      //  dirMeth.directorReport();
       /* orderMeth.createOrder("Mei", 75);

        dirMeth.directorReport();
        SCMethod.SCReport();*/

        /*orderMeth.getOrderByStatus(OrderStatus.isAccepted);
        orderMeth.deleteOrderByStatus(OrderStatus.isAccepted);*/
    }
}
