package ru.otus.spring.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) throws SQLException {
		ApplicationContext context = SpringApplication.run(LibraryApplication.class, args);
		// Console.main(args);
	}

}
