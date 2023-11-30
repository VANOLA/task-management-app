package com.example.group1todoapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Group1TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Group1TodoApplication.class, args);
	}

}
