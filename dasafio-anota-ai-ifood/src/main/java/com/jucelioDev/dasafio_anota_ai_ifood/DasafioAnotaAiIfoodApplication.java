package com.jucelioDev.dasafio_anota_ai_ifood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DasafioAnotaAiIfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(DasafioAnotaAiIfoodApplication.class, args);
	}

}
