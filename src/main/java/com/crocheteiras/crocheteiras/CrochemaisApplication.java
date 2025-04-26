package com.crocheteiras.crocheteiras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.crocheteiras.crocheteiras.repository")
public class CrochemaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrochemaisApplication.class, args);
	}

}
