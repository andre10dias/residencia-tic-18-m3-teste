package com.example.atividades.atividade06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PointTest {

    @Test
    public void testDistanceTo() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        
        // Verifica a distância entre (0,0) e (3,4) que deve ser 5
        assertEquals(5.0, p1.distanceTo(p2), 0.001);
        
        // Verifica a distância entre (3,4) e (0,0) que deve ser 5 (simetria)
        assertEquals(5.0, p2.distanceTo(p1), 0.001);
        
        // Verifica a distância entre (0,0) e (0,0) que deve ser 0
        assertEquals(0.0, p1.distanceTo(p1), 0.001);
    }

    @Test
    public void testDistanceToWithNull() {
        Point p1 = new Point(0, 0);
        
        // Verifica a exceção ao passar null
        assertThrows(IllegalArgumentException.class, () -> p1.distanceTo(null));
    }
}
