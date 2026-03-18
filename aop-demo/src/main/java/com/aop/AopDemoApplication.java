package com.aop;

import com.aop.service.BusinessService;
import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopDemoApplication implements CommandLineRunner {

	private final Logger LOG = LoggerFactory.getLogger(AopDemoApplication.class);

	@Autowired
	private BusinessService businessService;

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Override
	public void run(String @NonNull ... args) throws Exception {
		LOG.info("Value returned is: {}", businessService.calculateMax());
		LOG.info("Value returned is: {}", businessService.calculateMin());
	}
}
