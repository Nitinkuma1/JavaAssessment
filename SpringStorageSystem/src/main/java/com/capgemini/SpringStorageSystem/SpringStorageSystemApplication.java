package com.capgemini.SpringStorageSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringStorageSystemApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringStorageSystemApplication.class, args);

        System.out.println("Getting Default Storage");
        StorageService storage = context.getBean(StorageService.class);
        storage.storeFile("resume.pdf");

        context.close();
    }
}