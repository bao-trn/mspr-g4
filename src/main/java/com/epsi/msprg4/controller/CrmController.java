package com.epsi.msprg4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class CrmController {
    @Value("${external.url}")
    private String context;

    private static final String CUSTOMER_ENDPOINT = "/customers/";

    private final RestTemplate restTemplate;

    @Autowired
    public CrmController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/customers")
    public Object getCustomers() {
        return restTemplate.getForObject(context + ("/customers"), Object.class);
    }

    @GetMapping("/customers/{id}")
    public Object getCustomerById(@PathVariable String id) {
        return restTemplate.getForObject(context + (CUSTOMER_ENDPOINT + id), Object.class);
    }

    @GetMapping("/customers/{id}/orders")
    public Object getCustomerOrder(@PathVariable String id) {
        return restTemplate.getForObject(context + (CUSTOMER_ENDPOINT + id + "/orders"), Object.class);
    }

    @GetMapping("/customers/{id}/orders/{orderId}/products")
    public Object getCustomerOrderProducts(@PathVariable String id, @PathVariable String orderId) {
        return restTemplate.getForObject(context + (CUSTOMER_ENDPOINT + id + "/orders/" + orderId + "/products"), Object.class);
    }




}
