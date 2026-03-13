package com.example;

import com.example.componentscan.ComponentPersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.componentscan")
public class SpringComponentScanApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringComponentScanApplication.class);

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(SpringComponentScanApplication.class, args);

		ComponentPersonDAO componentPersonDAO = applicationContext.getBean(ComponentPersonDAO.class);
		ComponentPersonDAO componentPersonDAO2 = applicationContext.getBean(ComponentPersonDAO.class);

		log.info("{}", componentPersonDAO);
		log.info("{}", componentPersonDAO.getJdbcConnection());

		log.info("{}", componentPersonDAO2);
		log.info("{}", componentPersonDAO2.getJdbcConnection());

	}

}
