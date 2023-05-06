package com.epsi.msprg4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ErpController {

    @Value("${external.url}")
    private String context;

    private static final String PRODUCT_ENDPOINT = "/products";

    private final RestTemplate restTemplate;

    @Autowired
    public ErpController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/products")
    public Object getProducts() {
        return restTemplate.getForObject(context + (PRODUCT_ENDPOINT), Object.class);
    }

    @GetMapping("/products/{id}")
    public Object getProductById(@PathVariable String id) {
        return restTemplate.getForObject(context + (PRODUCT_ENDPOINT) + "/" +id, Object.class);
    }
}
