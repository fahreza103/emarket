package com.emarket.emarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.emarket")
@EntityScan("com.emarket.entity")
@EnableJpaRepositories("com.emarket.repository")
public class EmarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmarketApplication.class, args);
	}
}
