package com.database;

import com.database.dto.PersonDto;
import com.database.service.jdbc.PersonJdbcService;
import com.database.service.jpa.PersonJpaService;
import com.database.service.jpa.PersonJpaServiceV2;
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

	private final PersonJpaService personJpaService;

	private final PersonJpaServiceV2 personJpaServiceV2;

	public DatabaseDemoApplication(PersonJdbcService personJdbcService,
								   PersonJpaService personJpaService,
								   PersonJpaServiceV2 personJpaServiceV2) {
		this.personJdbcService = personJdbcService;
		this.personJpaService = personJpaService;
		this.personJpaServiceV2 = personJpaServiceV2;
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

		logger.info("Running JPA findAll() -> {}", personJpaService.findAll());
		logger.info("Running JPA findById for id 10002-> {}", personJpaService.findById(10002));
		logger.info("Running JPA save -> {}", personJpaService.saveOrUpdate(new PersonDto("Jason", "San Jose", LocalDateTime.now())));
		logger.info("Running JPA update -> {}", personJpaService.saveOrUpdate(new PersonDto(10002, "Jason", "Ontario", LocalDateTime.now())));
		logger.info("Running JPA deleteById -> {}", personJpaService.deleteById(10001));

		logger.info("Running Spring Data JPA findAll() -> {}", personJpaServiceV2.findAll());
		logger.info("Running Spring Data JPA findById for id 10002-> {}", personJpaServiceV2.findById(10002));
		logger.info("Running Spring Data JPA save -> {}", personJpaServiceV2.saveOrUpdate(new PersonDto("Jason", "San Jose", LocalDateTime.now())));
		logger.info("Running Spring Data JPA update -> {}", personJpaServiceV2.saveOrUpdate(new PersonDto(10002, "Jason", "Ontario", LocalDateTime.now())));
		logger.info("Running Spring Data JPA deleteById -> {}", personJpaServiceV2.deleteById(10001));
	}

}
