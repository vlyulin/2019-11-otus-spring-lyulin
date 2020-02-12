package ru.otus.spring.libraryspringnosql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class LibrarySpringNosqlApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(LibrarySpringNosqlApplication.class, args);
	}

}
