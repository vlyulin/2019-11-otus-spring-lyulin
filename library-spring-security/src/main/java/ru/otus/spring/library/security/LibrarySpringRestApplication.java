package ru.otus.spring.library.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.h2.tools.Console;

import java.sql.SQLException;


@SpringBootApplication
public class LibrarySpringRestApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(LibrarySpringRestApplication.class, args);
		Console.main(args);
	}

}
