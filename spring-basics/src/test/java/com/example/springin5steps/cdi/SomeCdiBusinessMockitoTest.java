package com.example.springin5steps.cdi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeCdiBusinessMockitoTest {

    @Mock
    SomeCdiDAO someCdiDAO;

    @InjectMocks
    SomeCdiBusiness someCdiBusiness;

    @Test
    void testFindGreatestWithFixedData() {
        when(someCdiDAO.getData()).thenReturn(new int[]{10, 20, 100});
        assertEquals(100, someCdiBusiness.findGreatest());
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 50, 500})
    void testFindGreatestWithDifferentDatasets(int maxValue) {
        when(someCdiDAO.getData()).thenReturn(new int[]{1, maxValue, 2});
        assertEquals(maxValue, someCdiBusiness.findGreatest());
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void testFindGreatestWithArrays(int[] input, int expected) {
        when(someCdiDAO.getData()).thenReturn(input);
        assertEquals(expected, someCdiBusiness.findGreatest());
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(new int[]{}, 0),                // empty array
                Arguments.of(new int[]{-10, -20, -5}, -5),           // negative values
                Arguments.of(new int[]{42}, 42),                     // one element
                Arguments.of(new int[]{1, 2, 3, 100}, 100),          // normal
                Arguments.of(new int[]{Integer.MIN_VALUE, 0}, 0)     // minimum value
        );
    }

}
