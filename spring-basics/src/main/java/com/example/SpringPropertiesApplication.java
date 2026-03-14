package com.example;

import com.example.springin5steps.properties.SomeExternalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.example.springin5steps")
@PropertySources({
		@PropertySource("classpath:application.properties"),
		@PropertySource("classpath:test.properties")
})
public class SpringPropertiesApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringPropertiesApplication.class);

	public static void main(String[] args) {
		try (var applicationContext = new AnnotationConfigApplicationContext(SpringPropertiesApplication.class)) {
			var someExternalService = applicationContext.getBean(SomeExternalService.class);
			log.info(someExternalService.returnServiceUrl());
			log.info(someExternalService.returnTestServiceUrl());
		}
	}

}
