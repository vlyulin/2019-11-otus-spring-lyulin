package ru.otus.spring.springbatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ru.otus.spring.springbatch.repositories.H2BookCommentsRepository;
import ru.otus.spring.springbatch.repositories.H2BooksRepository;
import ru.otus.spring.springbatch.repositories.MongoBookCommentsRepository;
import ru.otus.spring.springbatch.repositories.MongoBookRepository;


@EnableJpaRepositories(basePackageClasses = {H2BooksRepository.class, H2BookCommentsRepository.class})
@EnableMongoRepositories(basePackageClasses = {MongoBookRepository.class, MongoBookCommentsRepository.class})
@SpringBootApplication
public class SpringBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchApplication.class, args);
	}

}
