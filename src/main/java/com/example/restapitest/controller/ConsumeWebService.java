package com.example.restapitest.controller;

import java.util.Arrays;

import com.example.restapitest.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeWebService {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/template/products")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("http://localhost:8081/products", HttpMethod.GET, entity, String.class).getBody();
    }

    @PostMapping(value = "/template/products")
    public String createProducts(@RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<>(product, headers);

        return restTemplate.exchange("http://localhost:8081/products", HttpMethod.POST, entity, String.class).getBody();
    }

    @PutMapping(value = "/template/products/{id}")
    public String updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<>(product, headers);

        return restTemplate.exchange("http://localhost:8081/products/" + id, HttpMethod.PUT, entity, String.class)
                .getBody();
    }

    @DeleteMapping(value = "/template/products/{id}")
    public String deleteProduct(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Product> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("http://localhost:8081/products/" + id, HttpMethod.DELETE, entity, String.class)
                .getBody();
    }
}
