package com.example;

import com.example.springin5steps.basic.BinarySearchImpl;
import com.example.springin5steps.basic.BubbleSortAlgorithm;
import com.example.springin5steps.basic.QuickSortAlgorithm;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBasicsApplication {

	public static void main(String[] args) {

		BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgorithm());
		System.out.println(binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3));

		BinarySearchImpl binarySearch2 = new BinarySearchImpl(new QuickSortAlgorithm());
		System.out.println(binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3));

		//SpringApplication.run(SpringBasicsApplication.class, args);
	}

}
