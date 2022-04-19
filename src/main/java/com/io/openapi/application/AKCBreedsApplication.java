package com.io.openapi.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.io.openapi.controllers")
public class AKCBreedsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AKCBreedsApplication.class, args);
	}
}
