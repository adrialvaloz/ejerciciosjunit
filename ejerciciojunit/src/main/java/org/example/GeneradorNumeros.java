package org.example;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.*;

public class GeneradorNumeros {

    private final GeneradorNumeros generador = new GeneradorNumeros();
    /**
     * Genera un número aleatorio dentro de un rango especificado.
     *
     * @param min El límite inferior del rango (inclusive).
     * @param max El límite superior del rango (inclusive).
     * @return Un número aleatorio dentro del rango [min, max].
     */
    public int generarNumeroAleatorioEnRango(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("El máximo debe ser mayor que el mínimo");
        }
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

    /**
     * Verifica si un número es par.
     *
     * @param numero El número a verificar.
     * @return true si el número es par, false si es impar.
     */
    public boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    @RepeatedTest(100)
    void testGenerarNumeroAleatorioEnRango() {
        // Generar valores aleatorios para min y max
        int min = (int) (Math.random() * 1000);
        int max = min + (int) (Math.random() * 1000);

        // Generar un número aleatorio en el rango
        int numeroAleatorio = generador.generarNumeroAleatorioEnRango(min, max);

        // Verificar que el número generado esté dentro del rango
        assertTrue(numeroAleatorio >= min && numeroAleatorio <= max);
    }

    @RepeatedTest(100)
    void testEsPar() {
        // Generar un número aleatorio
        int numero = (int) (Math.random() * 1000);

        // Verificar si es par o impar
        boolean resultadoEsPar = generador.esPar(numero);

        // Verificar si el resultado es consistente con la paridad del número
        assertEquals(numero % 2 == 0, resultadoEsPar);
    }
}
