package com.example.CHALENGER_4;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Chalenger4Application {


	public static void main(String[] args) {
		SpringApplication.run(Chalenger4Application.class, args);
	}

	@Bean
	public CommandLineRunner init() {
		return args -> {
			System.out.println("Chalenger 4 API is up and running!");
			// Aquí puedes agregar lógica adicional, como inicialización de datos
		};
	}

}
