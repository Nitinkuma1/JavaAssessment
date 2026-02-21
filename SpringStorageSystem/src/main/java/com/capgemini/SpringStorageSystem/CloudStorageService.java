package com.capgemini.SpringStorageSystem;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component     
@Primary                       
@Scope("singleton")
public class CloudStorageService implements StorageService {

    public CloudStorageService() {
        System.out.println("CloudStorageService Bean Created");
    }

    @PostConstruct
    public void init() {
        System.out.println("CloudStorageService Bean Initialized");
    }

    @Override
    public void storeFile(String fileName) {
        System.out.println("File stored in Cloud Storage: " + fileName);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("CloudStorageService Bean Destroyed");
    }
}
