package com.database;

import com.database.entity.Person;
import com.database.mapper.PersonMapper;
import com.database.repository.jdbc.PersonJdbcDao;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Comparator;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(DatabaseDemoApplication.class);

	@Autowired
	private PersonJdbcDao personJdbcDao;

	@Autowired
	private PersonMapper personMapper;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String @NonNull ... args) throws Exception {
		logger.info("Running JDBC findAll()");
		personJdbcDao.findAll().stream()
				.map(personMapper::toDto)
				.forEach(dto -> logger.info("Person: {}", dto));

		logger.info("Running JDBC findAllV2() sorted by location descending");
		personJdbcDao.findAllV2().stream()
				.sorted(Comparator.comparing(Person::getLocation).reversed())
				.map(personMapper::toDto)
				.forEach(dto -> logger.info("Person: {}", dto));
	}
}
