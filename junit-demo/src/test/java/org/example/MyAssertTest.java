package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyAssertTest {

    List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");

    List<String> todosV2 = Arrays.asList("AWS", "Azure", "DevOps");

    @Test
    void test() {
        assertTrue(todos.contains("AWS"));
        assertFalse(todos.contains("K8s"));
        assertEquals(3, todos.size());
        assertArrayEquals(todos.toArray(), todosV2.toArray());
    }
}
