package ru.otus.spring.library.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class LibrarySpringActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarySpringActuatorApplication.class, args);
	}

}
