package com.example;

import com.example.springin5steps.basic.BinarySearchImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
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

		ConfigurableApplicationContext applicationContext =
				SpringApplication.run(SpringBasicsApplication.class, args);

		BinarySearchImpl binarySearchBean = applicationContext.getBean(BinarySearchImpl.class);

		BinarySearchImpl binarySearchBean2 = applicationContext.getBean(BinarySearchImpl.class);

		// Check bean scope
		log.info("Same bean instance? {}", binarySearchBean == binarySearchBean2);

		log.info(binarySearchBean.toString());
		log.info(binarySearchBean2.toString());

		int result = binarySearchBean.binarySearch(new int[] { 12, 4, 6 }, 3);
		log.info("Binary search result: {}", result);

	}

}
