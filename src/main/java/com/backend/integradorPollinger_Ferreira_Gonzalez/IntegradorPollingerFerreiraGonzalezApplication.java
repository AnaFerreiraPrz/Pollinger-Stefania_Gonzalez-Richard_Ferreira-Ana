package com.backend.integradorPollinger_Ferreira_Gonzalez;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntegradorPollingerFerreiraGonzalezApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(IntegradorPollingerFerreiraGonzalezApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(IntegradorPollingerFerreiraGonzalezApplication.class, args);
		LOGGER.info("Proyecto integrador is now running ...");
	}

}
