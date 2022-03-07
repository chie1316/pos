package com.ramirez.pos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PosApplication extends ServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PosApplication.class, args);
	}

}
