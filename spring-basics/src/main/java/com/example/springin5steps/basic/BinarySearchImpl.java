package com.example.springin5steps.basic;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BinarySearchImpl {

    private static final Logger log = LoggerFactory.getLogger(BinarySearchImpl.class);

    @Autowired
    @Qualifier("bubble")
    private SortAlgorithm sortAlgorithm;

    public int binarySearch(int[] numbers, int numberToSearchFor) {
        int[] sortedNumbers = sortAlgorithm.sort(numbers);
        log.info("Sort Algorithm: {}", sortAlgorithm);
        return 3;
    }

    // Runs after dependency injection is complete.
    @PostConstruct
    public void postConstruct() {
        log.info("Executing post construct call");
    }

    // Runs before the bean is removed from the context (only for singleton beans)
    @PreDestroy
    public void preDestroy() {
        log.info("Executing pre destroy call");
    }
}
