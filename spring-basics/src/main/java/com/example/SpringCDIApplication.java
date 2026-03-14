package com.example;

import com.example.springin5steps.cdi.SomeCdiBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.springin5steps")
public class SpringCDIApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringCDIApplication.class);

	public static void main(String[] args) {

		/*ConfigurableApplicationContext applicationContext =
				SpringApplication.run(SpringCDIApplication.class, args);*/

		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(SpringCDIApplication.class);

		SomeCdiBusiness someCdiBusiness = applicationContext.getBean(SomeCdiBusiness.class);

		log.info("{} dao {}", someCdiBusiness, someCdiBusiness.getSomeCdiDAO());

		applicationContext.close();
	}

}
