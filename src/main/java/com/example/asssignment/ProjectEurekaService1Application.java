package com.example.asssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProjectEurekaService1Application {

	@Bean
	@LoadBalanced
	public WebClient.Builder webClientBuilder() {
	    return WebClient.builder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectEurekaService1Application.class, args);
	}

}
