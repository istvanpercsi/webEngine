package de.percsi.webEngine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"de.percsi.webEngine"})
public class WebEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebEngineApplication.class, args);
	}

}
