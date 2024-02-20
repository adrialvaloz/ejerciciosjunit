package org.example;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("ComponenteA")
public class ComponenteA {
    private ComponenteA componenteA = new ComponenteA();

    /**
     * Realiza una operación en el ComponenteA.
     * @return El resultado de la operación.
     */
    public String operacionA() {
        // Lógica de la operación A
        return "Resultado de operación A";
    }
    @Test
    void pruebaOperacionA() {
        String resultado = componenteA.operacionA();
        assertEquals("Resultado de operación A", resultado);
    }
}
