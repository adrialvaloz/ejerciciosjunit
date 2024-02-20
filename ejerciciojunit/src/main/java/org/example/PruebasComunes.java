package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PruebasComunes {
    // Método predeterminado con una prueba común que puede ser compartida
    @Test
    void pruebaEjecucionBasica() {
        assertTrue(ejecucionBasica(), "La ejecución básica debe retornar verdadero");
    }

    // Método que las clases concretas deben implementar
    boolean ejecucionBasica() {
        return false;
    }
}
