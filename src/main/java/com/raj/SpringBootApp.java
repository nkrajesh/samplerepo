package com.raj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.raj")
@SpringBootApplication
@RefreshScope
public class SpringBootApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}
}
