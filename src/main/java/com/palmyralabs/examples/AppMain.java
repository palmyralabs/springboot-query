package com.palmyralabs.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.palmyralabs.palmyra.spring.PalmyraSpringConfiguration;

@EntityScan
@EnableJpaRepositories
@SpringBootApplication
@Import(PalmyraSpringConfiguration.class)
public class AppMain {
	public static void main(String[] args) {
		SpringApplication.run(AppMain.class, args);
	}
}
