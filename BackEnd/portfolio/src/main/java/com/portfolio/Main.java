package com.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.portfolio")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}