package ru.otus.spring.libraryspringdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.h2.tools.Console;

import java.sql.SQLException;

@SpringBootApplication
public class LibrarySpringDataApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(LibrarySpringDataApplication.class, args);
		Console.main(args);
	}

}
