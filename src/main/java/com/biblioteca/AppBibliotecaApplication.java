package com.biblioteca;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class AppBibliotecaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppBibliotecaApplication.class, args);
	}

	@Bean
	public OpenAPI info(){
		return new OpenAPI()
				.info(new Info()
						.title("App-Generica")
						.description("Aplicación genérica con caso de uso de una Biblioteca.")
						.contact(new Contact()
								.email("prodas@facultad.sanfrancisco.utn.edu.ar"))
						.version("v1"));
	}
}
