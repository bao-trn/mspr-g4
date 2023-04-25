package com.epsi.msprg4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ErpController {

    @Value("${external.url}")
    private String context;

    private final RestTemplate restTemplate;

    @Autowired
    public ErpController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/customers")
    public Object getCustomers() {
        return restTemplate.getForObject(context + ("/customers"), Object.class);
    }

}
