package com.mss.jpa;

import java.util.HashSet;
import java.util.Set;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.mss.jpa.model.Book;
import com.mss.jpa.model.BookCategory;
import com.mss.jpa.repository.BookCategoryRepository;

@SpringBootApplication

public class JpaOneToManySpringBootApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(JpaOneToManySpringBootApplication.class);

	@Autowired
    DataSource dataSource;
	
	@Autowired
	private BookCategoryRepository bookCategoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaOneToManySpringBootApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String[] args) throws Exception {
		// save a couple of categories
		BookCategory categoryA = new BookCategory("Category A");
		Set bookAs = new HashSet<Book>() {
			{
				add(new Book("Raghu A1", categoryA));
				add(new Book("Raghu A2", categoryA));
				add(new Book("Raghu A3", categoryA));
			}
		};
		categoryA.setBooks(bookAs);

		BookCategory categoryB = new BookCategory("Category B");
		Set bookBs = new HashSet<Book>() {
			{
				add(new Book("Babu B1", categoryB));
				add(new Book("Babu B2", categoryB));
				add(new Book("Babu B3", categoryB));
			}
		};
		categoryB.setBooks(bookBs);

		bookCategoryRepository.saveAll(new HashSet<BookCategory>() {
			{
				add(categoryA);
				add(categoryB);
			}
		});

		// fetch all categories
		for (BookCategory bookCategory : bookCategoryRepository.findAll()) {
			logger.info(bookCategory.toString());
		}
	}
}
