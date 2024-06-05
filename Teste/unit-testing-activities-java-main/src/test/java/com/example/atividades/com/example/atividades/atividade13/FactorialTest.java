package com.example.atividades.atividade13;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FactorialTest {

    @Test
    public void testCalculate_Zero() {
        // Teste para fatorial de 0
        Factorial factorial = new Factorial();
        int result = factorial.calculate(0);
        assertEquals(1, result);
    }

    @Test
    public void testCalculate_PositiveNumber() {
        // Teste para fatorial de um número positivo
        Factorial factorial = new Factorial();
        int result = factorial.calculate(5);
        assertEquals(120, result);
    }

    @Test
    public void testCalculate_NegativeNumber() {
        // Teste para verificar se uma exceção é lançada para um número negativo
        Factorial factorial = new Factorial();
        assertThrows(IllegalArgumentException.class, () -> {
            factorial.calculate(-5);
        });
    }
}
