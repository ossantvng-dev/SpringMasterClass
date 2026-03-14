package org.example;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyMathTest {

    @Test
    void test() {
        assertEquals(6, new MyMath().calculateSum(new int[] { 1, 2, 3 }));
    }

    @Test
    void test2() {
        assertEquals(0, new MyMath().calculateSum(new int[] { }));
    }

    @ParameterizedTest
    @CsvSource({"1,2,3,6", "0,0,0,0", "5,-2,1,4"})
    void calculateSumTestWithArgs(int num1, int num2, int num3, int expected) {
        assertEquals(expected, new MyMath().calculateSum(new int[] { num1, num2, num3 }));
    }

    @ParameterizedTest
    @MethodSource("provideArraysForSum")
    void calculateSumTestWithArgsV2(int[] numbers, int expected) {
        assertEquals(expected, new MyMath().calculateSum(numbers));
    }

    private static Stream<Arguments> provideArraysForSum() {
        return Stream.of(Arguments.of(new int[] {1, 2, 3}, 6),
                Arguments.of(new int[] {}, 0),
                Arguments.of(new int[] {42}, 42),
                Arguments.of(new int[] {5, -2, 1}, 4));
    }

}