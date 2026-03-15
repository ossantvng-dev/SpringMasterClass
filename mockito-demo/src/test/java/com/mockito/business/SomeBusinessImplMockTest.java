package com.mockito.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessImplMockTest {

    @ParameterizedTest
    @MethodSource("getArraysForTesting")
    void findTheGreatestFromAllDataMockTestV1(int[] numbers, int expected) {
        DataService dataServiceMock = mock(DataService.class);
        when(dataServiceMock.retrieveAllData()).thenReturn(numbers);
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceMock);
        assertEquals(expected, someBusiness.findTheGreatestFromAllData());
    }

    private static Stream<Arguments> getArraysForTesting() {
        return Stream.of(Arguments.of(new int[]{1, 10, 55, 2, 8}, 55),
                Arguments.of(new int[]{}, -1),
                Arguments.of(new int[]{42}, 42),
                Arguments.of(new int[]{-5, -2, -9}, -2));
    }
}
