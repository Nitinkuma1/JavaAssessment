package com.example.ApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookingServiceApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingServiceApiGatewayApplication.class, args);
	}

}
