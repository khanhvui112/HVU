package com.hvu.HVU;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HvuApplication {

	public static void main(String[] args) {
		SpringApplication.run(HvuApplication.class, args);
	}

}
