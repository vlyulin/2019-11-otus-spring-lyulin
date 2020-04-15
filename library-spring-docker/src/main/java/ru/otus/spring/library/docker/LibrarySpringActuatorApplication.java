package ru.otus.spring.library.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
// @EnableWebMvc // Если включить, то получаю ошибку No mapping for GET /css/bootstrap.min.css
// Тут дали совет убрать @EnableWebMvc, и так все работает
// https://stackoverflow.com/questions/38236353/spring-boot-thymeleaf-layout-no-mapping-found-for-http-request-with-uri-css
public class LibrarySpringActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarySpringActuatorApplication.class, args);
	}

}
