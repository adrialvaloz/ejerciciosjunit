package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

public class ProcesadorDeTareas {
    private GestorDeTareas procesador = new GestorDeTareas();

    @Test
    void testEjecutarTareaLarga() {
        assertTimeoutPreemptively(
                Duration.ofMillis(100), // Tiempo máximo de ejecución permitido
                () -> {
                    procesador.agregarTarea(String.valueOf(200)); // Intenta ejecutar una tarea que tarda 200 milisegundos
                }
        );
    }
}