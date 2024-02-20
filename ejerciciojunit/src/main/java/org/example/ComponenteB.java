package org.example;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("ComponenteB")
public class ComponenteB {
    private ComponenteB componenteB = new ComponenteB();

    /**
     * Realiza una operación en el ComponenteB.
     * @return El resultado de la operación.
     */
    public int operacionB() {
        // Lógica de la operación B
        return 42; // Un resultado de ejemplo
    }
    @Test
    void pruebaOperacionB() {
        int resultado = componenteB.operacionB();
        assertEquals(42, resultado);
    }
}
