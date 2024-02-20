package org.example;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraAvanzada {
    /**
     * Calcula la raíz cuadrada de un número.
     * @param numero El número para calcular la raíz cuadrada.
     * @return La raíz cuadrada del número.
     */
    public double raizCuadrada(double numero) {
        // Implementación pendiente o en revisión
        return Math.sqrt(numero);
    }

    /**
     * Calcula el logaritmo natural de un número.
     * @param numero El número para calcular el logaritmo.
     * @return El logaritmo natural del número.
     */
    public double logaritmoNatural(double numero) {
        // Implementación pendiente o en revisión
        return Math.log(numero);
    }

    /**
     * Calcula el factorial de un número.
     * @param numero El número para calcular el factorial.
     * @return El factorial del número.
     */
    public long factorial(int numero) {
        // Implementación correcta requerida
        if (numero < 0) {
            throw new IllegalArgumentException("Número debe ser mayor o igual a 0.");
        }
        long resultado = 1;
        for (int i = 2; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }

    @Test
    void testRaizCuadrada() {
        CalculadoraAvanzada calculadora = new CalculadoraAvanzada();
        double resultado = calculadora.raizCuadrada(81);
        assertEquals(9, resultado);
    }

    @Test
    void testLogaritmoNatural() {
        CalculadoraAvanzada calculadora = new CalculadoraAvanzada();
        double resultado = calculadora.logaritmoNatural(10);
        assertEquals(2.302585092994046, resultado);
    }

    @Disabled("Implementación pendiente o en revisión")
    @Test
    void testFactorial() {
        CalculadoraAvanzada calculadora = new CalculadoraAvanzada();
        long resultado = calculadora.factorial(5);
        assertEquals(120, resultado);
    }
}
