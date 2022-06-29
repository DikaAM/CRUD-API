package com.portofolio.tryapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class TryApiApplication {

    public static void main(String[] args) {


        SpringApplication.run(TryApiApplication.class, args);


    }

}
