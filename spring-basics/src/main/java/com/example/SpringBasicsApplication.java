package com.example;

import com.example.springin5steps.basic.BinarySearchImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.springin5steps")
public class SpringBasicsApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBasicsApplication.class);

	public static void main(String[] args) {

		/*
			This code will work with traditional dependency management. No Spring annotations.

			BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
			System.out.println(binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3));

			BinarySearchImpl binarySearch2 = new BinarySearchImpl(new QuickSortAlgorithm());
			System.out.println(binarySearch2.binarySearch(new int[] { 12, 4, 6 }, 3));
		*/


		/*
			This one does not work because we are removing the spring boot starter.

		 	ConfigurableApplicationContext applicationContext =
		 		SpringApplication.run(SpringBasicsApplication.class, args);
		 */

		try (var applicationContext = new AnnotationConfigApplicationContext(SpringScopeApplication.class)) {
			var binarySearchBean = applicationContext.getBean(BinarySearchImpl.class);
			var binarySearchBean2 = applicationContext.getBean(BinarySearchImpl.class);

			// Check bean scope
			log.info("Same bean instance? {}", binarySearchBean == binarySearchBean2);

			log.info(binarySearchBean.toString());
			log.info(binarySearchBean2.toString());

			int result = binarySearchBean.binarySearch(new int[] { 12, 4, 6 }, 3);
			log.info("Binary search result: {}", result);
		}
	}

}
