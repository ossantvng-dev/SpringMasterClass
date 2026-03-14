package com.example;

import com.example.springin5steps.scope.PersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.springin5steps")
public class SpringScopeApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringScopeApplication.class);

	public static void main(String[] args) {

		/*ConfigurableApplicationContext applicationContext =
				SpringApplication.run(SpringScopeApplication.class, args);*/

		ApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(SpringScopeApplication.class);

		PersonDAO personDAO = applicationContext.getBean(PersonDAO.class);
		PersonDAO personDAO2 = applicationContext.getBean(PersonDAO.class);

		/*
			Scenario: PersonDAO is prototype, JdbcConnection is singleton

			Result: com.example.springin5steps.scope.PersonDAO@476ec9d0
					com.example.springin5steps.scope.JdbcConnection@325bb9a6
					com.example.springin5steps.scope.PersonDAO@1d12b024
					com.example.springin5steps.scope.JdbcConnection@325bb9a6
		*/

		/*
			Scenario: PersonDAO is singleton, JdbcConnection is prototype
			Result: You will not get a different JdbcConnection instance.
			Fix: Need to configure a proxy obj.

			Here you will get a new JdbcConnection every time.
		 */
		log.info("{}", personDAO);
		log.info("{}", personDAO.getJdbcConnection());

		log.info("{}", personDAO2);
		log.info("{}", personDAO2.getJdbcConnection());

	}

}
