package com.example.atividades.atividade08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StatisticsTest {

    @Test
    public void testCalculateAverage_ValidList() {
        Statistics statistics = new Statistics();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        double result = statistics.calculateAverage(numbers);

        assertEquals(3.0, result, 0.001);
    }

    @Test
    public void testCalculateAverage_SingleElement() {
        Statistics statistics = new Statistics();
        List<Integer> numbers = Collections.singletonList(10);

        double result = statistics.calculateAverage(numbers);

        assertEquals(10.0, result, 0.001);
    }

    @Test
    public void testCalculateAverage_EmptyList() {
        Statistics statistics = new Statistics();
        List<Integer> numbers = Collections.emptyList();

        assertThrows(IllegalArgumentException.class, () -> {
            statistics.calculateAverage(numbers);
        });
    }

    @Test
    public void testCalculateAverage_NullList() {
        Statistics statistics = new Statistics();

        assertThrows(IllegalArgumentException.class, () -> {
            statistics.calculateAverage(null);
        });
    }

    @Test
    public void testCalculateAverage_ListWithNegativeNumbers() {
        Statistics statistics = new Statistics();
        List<Integer> numbers = Arrays.asList(-1, -2, -3, -4, -5);

        double result = statistics.calculateAverage(numbers);

        assertEquals(-3.0, result, 0.001);
    }

    @Test
    public void testCalculateAverage_ListWithMixedNumbers() {
        Statistics statistics = new Statistics();
        List<Integer> numbers = Arrays.asList(-1, 0, 1, 2, -2);

        double result = statistics.calculateAverage(numbers);

        assertEquals(0.0, result, 0.001);
    }
}
