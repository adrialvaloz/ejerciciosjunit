package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ProcesadorTareasPesadas {

    private ProcesadorTareasPesadas procesador = new ProcesadorTareasPesadas();

    /**
     * Realiza una operación de procesamiento intensivo que simula cálculos complejos o
     * procesamiento de grandes volúmenes de datos.
     *
     * @return El resultado de la operación de procesamiento.
     */
    public long realizarOperacionIntensiva() {
        // Simulación de una tarea intensiva, como un algoritmo de ordenamiento en una gran colección,
        // cálculo de operaciones matemáticas complejas, etc.
        long resultado = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            resultado += i;
        }
        return resultado;
    }

    @Test
    void testRealizarOperacionIntensiva() {
        assertTimeoutPreemptively(
                java.time.Duration.ofSeconds(5), // Límite de tiempo en segundos
                () -> {
                    long resultado = procesador.realizarOperacionIntensiva();
                    // Aquí podrías agregar más aserciones para validar el resultado si es necesario
                },
                "La operación intensiva tardó más de 5 segundos" // Mensaje de error si la prueba falla por tiempo de espera excedido
        );
    }
}
