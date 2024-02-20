package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Prueba {
    @Test
    void testSum() {
        App myClass= new App();
        int result = myClass.sum(3, 4);
        assertEquals(7, result);
    }
}
