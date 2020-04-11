package ru.otus.spring.libraryacl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class LibrarySpringAclApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarySpringAclApplication.class, args);
	}

}
