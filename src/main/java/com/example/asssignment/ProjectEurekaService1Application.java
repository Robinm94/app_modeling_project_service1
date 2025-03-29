package com.example.asssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProjectEurekaService1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjectEurekaService1Application.class, args);
	}

}
