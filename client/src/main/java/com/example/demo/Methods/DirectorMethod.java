package com.example.demo.Methods;

import com.example.demo.MainClasses.Director.Director;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class DirectorMethod {

    public Director createDirector() {
        String address = "http://localhost:8082/director/";
        RestTemplate restTemp = new RestTemplate();

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", "Konrad").
                queryParam("woodAmount", 100).
                queryParam("balance", 0);

        System.out.println("Director create");
        HttpEntity<Director> response = restTemp.exchange(builder.toUriString(), HttpMethod.POST, null, Director.class);
        System.out.println(response.getBody());
        return response.getBody();
    }

    public void getDirector() {
        String address = "http://localhost:8082/director/";
        RestTemplate restTemp = new RestTemplate();

        System.out.println("Director get");
        HttpEntity<Director> response = restTemp.exchange(address, HttpMethod.GET, null, Director.class);
        System.out.println(response.getBody());
    }

    public void directorReport()
    {
        String address = "http://localhost:8082/director/";
        RestTemplate restTemp = new RestTemplate();

        System.out.println("Director report");
        HttpEntity<String> response = restTemp.exchange(address, HttpMethod.GET, null, String.class);
        System.out.println(response.getBody());
    }
}
