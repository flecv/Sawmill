package com.example.demo.Methods;

import com.example.demo.MainClasses.SalesController.SalesController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class SCMethod {

    public void createSC() {
        String address = "http://localhost:8082/SalesController/";
        RestTemplate restTemp = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", "Kimo").
                queryParam("balance", 100);
        System.out.println("Sales controller create");
        HttpEntity<SalesController> response = restTemp.exchange(builder.toUriString(),
                HttpMethod.POST, null, SalesController.class);

        System.out.println(response.getBody());
    }

    public void SCReport()
    {
        String address = "http://localhost:8082/SalesController/";
        RestTemplate restTemp = new RestTemplate();

        System.out.println("Sales controller report");
        HttpEntity<String> response = restTemp.exchange(address, HttpMethod.GET, null, String.class);
        System.out.println(response.getBody());
    }
}
