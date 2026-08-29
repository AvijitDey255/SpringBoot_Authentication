package com.avijitdey255.loging_spring_secqurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogingSpringSecqurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogingSpringSecqurityApplication.class, args);
        System.out.println("Server is Running at localhost 8080 port ");
	}

}
