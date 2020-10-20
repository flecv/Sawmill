package com.example.demo.Methods;

import com.example.demo.MainClasses.Customer.Customer;
import com.example.demo.MainClasses.Director.Director;
import com.example.demo.MainClasses.MapModule;
import com.example.demo.MainClasses.Order.OrderStatus;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class OrderMethod {
    public void createOrder(Director director, Customer customer)
    {
        final String address = "http://localhost:8082/order/";
        RestTemplate restTemp = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("directorName", director.getName()).
                queryParam("woodAmount", director.getWoodAmount()).
                queryParam("balance", director.getBalance()).
                queryParam("customerName", customer.getName()).
                queryParam("customerAge", customer.getAge()).
                queryParam("customerRequest", customer.getRequest());

        HttpEntity<Boolean> response = restTemp.exchange(builder.toUriString(),
                HttpMethod.POST, null, Boolean.class);

        if(!response.getBody())
        {
            System.out.println("We can not complete this order.");
        } else
            System.out.println("We can complete this order.");
    }

    public void getOrderByStatus(OrderStatus status)
    {
        String address = "http://localhost:8082/order/";
        RestTemplate restTemp = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("status", status).
                queryParam("module", MapModule.byStatus);
        HttpEntity<String> response = restTemp.exchange(builder.toUriString(), HttpMethod.GET, null, String.class);
        System.out.println(response.getBody());
    }
    public void deleteOrderByStatus(OrderStatus status)
    {
        String address = "http://localhost:8082/order/";
        RestTemplate restTemp = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", "").
                queryParam("status", status);
        HttpEntity<String> response = restTemp.exchange(builder.toUriString(), HttpMethod.DELETE, null, String.class);
        System.out.println(response.getBody());
    }
}
