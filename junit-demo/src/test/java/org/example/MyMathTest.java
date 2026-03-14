package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMathTest {

    @Test
    void test() {
        assertEquals(6, new MyMath().calculateSum(new int[] { 1, 2, 3 }));
    }
}