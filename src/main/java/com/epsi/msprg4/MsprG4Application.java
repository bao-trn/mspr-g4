package com.epsi.msprg4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MsprG4Application {

    public static void main(String[] args) {

        SpringApplication.run(MsprG4Application.class, args);
        System.out.println("hello world");
    }

}
