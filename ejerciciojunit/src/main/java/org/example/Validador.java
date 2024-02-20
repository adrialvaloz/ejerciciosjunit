package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Validador {
    /**
     * Valida si el texto proporcionado es nulo o está vacío.
     *
     * @param texto El texto a validar.
     * @throws TextoInvalidoException Si el texto es nulo o vacío.
     */
    public void validarTexto(String texto) throws TextoInvalidoException {
        if (texto == null || texto.isEmpty()) {
            throw new TextoInvalidoException("El texto no puede ser nulo ni vacío");
        }
        // Lógica adicional de validación si es necesaria
    }

    // Prueba unitaria para verificar que se lanza la excepción adecuada
    @Test
    void testValidarTexto() {
        Validador validador = new Validador();

        // Verificar que una cadena nula lance la excepción
        assertThrows(TextoInvalidoException.class, () -> validador.validarTexto(null));

        // Verificar que una cadena vacía lance la excepción
        assertThrows(TextoInvalidoException.class, () -> validador.validarTexto(""));

        // Verificar que una cadena válida no lance una excepción
        assertDoesNotThrow(() -> validador.validarTexto("Luis es el mejor profesor"));
    }
}

/**
 * Excepción personalizada para indicar que un texto no cumple con los criterios de validación.
 */
class TextoInvalidoException extends Exception {
    public TextoInvalidoException(String mensaje) {
        super(mensaje);
    }

}
