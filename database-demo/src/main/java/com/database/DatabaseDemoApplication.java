package com.database;

import com.database.dto.PersonDto;
import com.database.service.jdbc.PersonJdbcService;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(DatabaseDemoApplication.class);

	private final PersonJdbcService personJdbcService;

	public DatabaseDemoApplication(PersonJdbcService personJdbcService) {
		this.personJdbcService = personJdbcService;
	}

	static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String @NonNull ... args) {
		logger.info("Running JDBC findAll() -> {}", personJdbcService.findAll());
		logger.info("Running JDBC findById for id 10002-> {}", personJdbcService.findById(10002));
		logger.info("Running JDBC insert -> {}", personJdbcService.insert(new PersonDto(10004, "Jason", "San Jose", LocalDateTime.now())));
		logger.info("Running JDBC update -> {}", personJdbcService.update(new PersonDto(10004, "Jason", "Montreal", LocalDateTime.now())));
		logger.info("Running JDBC deleteById -> {}", personJdbcService.deleteById(10001));
	}

}
