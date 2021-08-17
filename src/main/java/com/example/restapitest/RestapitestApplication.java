package com.example.restapitest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class RestapitestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapitestApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String hello() {
		return "Hello World";
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
