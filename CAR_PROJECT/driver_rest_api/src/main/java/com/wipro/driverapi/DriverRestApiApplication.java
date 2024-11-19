package com.wipro.driverapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DriverRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverRestApiApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate() {

		return new RestTemplate();

	}
}
