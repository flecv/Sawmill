package com.example.demo.Methods;

import com.example.demo.MainClasses.Customer.Customer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class CustomerMethod {
    public void createCustomer()
    {
        final String address = "http://localhost:8082/customer/";
        RestTemplate restTemp = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", "Vigor").
                queryParam("age", 30).
                queryParam("request", 100);

        System.out.println("Create new customers");
        HttpEntity<Customer> response = restTemp.exchange(builder.toUriString(), HttpMethod.POST, null, Customer.class);
        System.out.println(response.getBody());

        builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", "Savana").
                queryParam("age", 25).
                queryParam("request", 150);
        response = restTemp.exchange(builder.toUriString(), HttpMethod.POST, null, Customer.class);
        System.out.println(response.getBody());
    }

    public void customerReport()
    {
        String address = "http://localhost:8082/customer/";
        RestTemplate restTemp = new RestTemplate();

        System.out.println("Customer report");
        HttpEntity<String> response = restTemp.exchange(address, HttpMethod.GET, null, String.class);
        System.out.println(response.getBody());
    }
}
