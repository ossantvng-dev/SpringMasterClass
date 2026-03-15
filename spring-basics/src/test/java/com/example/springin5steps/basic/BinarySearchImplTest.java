package com.example.springin5steps.basic;

import com.example.SpringBasicsApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringBasicsApplication.class)
public class BinarySearchImplTest {

    @Autowired
    BinarySearchImpl binarySearchImplObj;

    @Test
    void binarySearchBasicTest() {
        assertEquals(3, binarySearchImplObj.binarySearch(new int[]{}, 4));
    }
}
