package ru.otus.spring.libraryspringnosql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ru.otus.spring.libraryspringnosql.repositories.AuthorRepository;

@EnableMongoRepositories
@SpringBootApplication
public class LibrarySpringNosqlApplication {

	@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
	@Autowired
	private AuthorRepository authorRepository;

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(LibrarySpringNosqlApplication.class, args);

//		ApplicationContext context = SpringApplication.run(LibrarySpringNosqlApplication.class);
////		AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
//		Author author = new Author();
////		author.setId(1);
//		author.setCountry("Russia");
//		author.setDateOfBirth(LocalDate.now());
//		author.setSex('M');
//		author.setName("Brodsky");
////		authorRepository.save(author);
//
//		PublishingHouse publishingHouse = new PublishingHouse();
////		publishingHouse.setId(1);
//		publishingHouse.setName("ИК «Столица» (Изд. группа GELEOS Publishing House)");
//		publishingHouse.setSettlementYear(2010);
//
//		LookupValue lookupValueRU = new LookupValue();
//		lookupValueRU.setLookupType("GENRES");
//		lookupValueRU.setLanguage("RU");
//		lookupValueRU.setLookupCode("HARD_SCIENCE_FICTION");
//		lookupValueRU.setMeaning("Твердая научная фантастика");
//		lookupValueRU.setDescription("Твердая научная фантастика");
//		lookupValueRU.setEnabledFlag('Y');
//
//		LookupValue lookupValueEN = new LookupValue();
//		lookupValueEN.setLookupType("GENRES");
//		lookupValueEN.setLanguage("RU");
//		lookupValueEN.setLookupCode("HARD_SCIENCE_FICTION");
//		lookupValueEN.setMeaning("Hard SF");
//		lookupValueEN.setDescription("Hard science fiction");
//		lookupValueEN.setEnabledFlag('Y');
//
//		List<LookupValue> lookupValueList = List.of(lookupValueRU, lookupValueEN);
//
//		Book book = new Book(2, "В ядовитом поясе", 2010, 320, lookupValueList, author, publishingHouse);
//		BooksRepository booksRepository = context.getBean(BooksRepository.class);
//		booksRepository.save(book);
//
//		Thread.sleep(3000);
//		authorRepository.findAll().forEach(p -> System.out.println(p.getName()));
	}

}
