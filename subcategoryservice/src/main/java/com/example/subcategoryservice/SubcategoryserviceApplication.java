package com.example.subcategoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SubcategoryserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubcategoryserviceApplication.class, args);
    }

}
