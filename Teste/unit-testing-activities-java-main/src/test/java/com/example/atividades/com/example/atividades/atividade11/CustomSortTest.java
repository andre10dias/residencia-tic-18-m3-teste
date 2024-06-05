package com.example.atividades.atividade11;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomSortTest {

    @Test
    public void testCustomSort() {
        // Lista de números desordenada
        List<Integer> unsortedNumbers = Arrays.asList(5, 2, 8, 1, 9);

        // Lista de números esperada em ordem decrescente
        List<Integer> expectedSortedNumbers = Arrays.asList(9, 8, 5, 2, 1);

        // Criar uma instância da classe CustomSort
        CustomSort customSort = new CustomSort();

        // Chamar o método a ser testado
        List<Integer> sortedNumbers = customSort.customSort(unsortedNumbers);

        // Verificar se a lista de números foi ordenada corretamente
        assertEquals(expectedSortedNumbers, sortedNumbers);
    }

    @Test
    public void testCustomSort_EmptyList() {
        // Lista de números vazia
        List<Integer> emptyList = Collections.emptyList();

        // Criar uma instância da classe CustomSort
        CustomSort customSort = new CustomSort();

        // Chamar o método a ser testado
        List<Integer> sortedNumbers = customSort.customSort(emptyList);

        // Verificar se a lista de números vazia foi manipulada corretamente
        assertTrue(sortedNumbers.isEmpty());
    }
}
