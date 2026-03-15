package com.example.springin5steps.basic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "/applicationContextTest.xml")
public class BinarySearchXmlImplTest {

    @Autowired
    BinarySearchImpl binarySearchImplObj;

    @Test
    void binarySearchBasicTest() {
        assertEquals(3, binarySearchImplObj.binarySearch(new int[]{}, 4));
    }

}
