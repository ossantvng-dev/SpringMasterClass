package com.example;

import com.example.springin5steps.xml.XmlPersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan("com.example.springin5steps")
public class SpringXMLContextApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringXMLContextApplication.class);

	public static void main(String[] args) {

		try (var applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			//log.info("Beans Loaded -> {}", (Object) applicationContext.getBeanDefinitionNames());
			log.info("Beans loaded:\n{}", String.join("\n", applicationContext.getBeanDefinitionNames()));
			var xmlPersonDAO = applicationContext.getBean(XmlPersonDAO.class);
			log.info("{} {}", xmlPersonDAO, xmlPersonDAO.getXmlJdbcConnection());
		}
	}

}
