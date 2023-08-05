package com.gg.ADV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AdvApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvApplication.class, args);
	}

}