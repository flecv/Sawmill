package com.example.demo.Methods;

import com.example.demo.MainClasses.Customer.Customer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class CustomerMethod {
    public Customer createCustomer()
    {
        final String address = "http://localhost:8082/customer/";
        RestTemplate restTemp = new RestTemplate();

        String name = null;
        System.out.println("Enter the name of customer");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", "Vigor").
                queryParam("age", 30).
                queryParam("request", 100);

        System.out.println("Create new customer");
        HttpEntity<Customer> response = restTemp.exchange(builder.toUriString(), HttpMethod.POST, null, Customer.class);
        System.out.println(response.getBody());
        return response.getBody();
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
