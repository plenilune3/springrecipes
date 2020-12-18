package com.apress.springrecipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.apress.*")
public class SpringrecipesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringrecipesApplication.class, args);
    }

}
