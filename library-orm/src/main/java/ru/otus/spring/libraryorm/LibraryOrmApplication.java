package ru.otus.spring.libraryorm;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryOrmApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(LibraryOrmApplication.class, args);
		Console.main(args);
	}

}
