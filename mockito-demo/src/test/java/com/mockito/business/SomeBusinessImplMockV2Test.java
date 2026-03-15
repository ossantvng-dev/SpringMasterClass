package com.mockito.business;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockV2Test {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl someBusiness;

    @ParameterizedTest
    @MethodSource("getArraysForTesting")
    void findTheGreatestFromAllDataMockTestV1(int[] numbers, int expected) {
        when(dataServiceMock.retrieveAllData()).thenReturn(numbers);
        assertEquals(expected, someBusiness.findTheGreatestFromAllData());
    }

    private static Stream<Arguments> getArraysForTesting() {
        return Stream.of(Arguments.of(new int[]{1, 10, 55, 2, 8}, 55),
                Arguments.of(new int[]{}, -1),
                Arguments.of(new int[]{42}, 42),
                Arguments.of(new int[]{-5, -2, -9}, -2));
    }
}
