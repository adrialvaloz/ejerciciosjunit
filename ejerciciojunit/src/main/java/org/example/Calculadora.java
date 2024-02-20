package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Calculadora {
    /**
     * Suma dos números enteros.
     * @param a Primer sumando.
     * @param b Segundo sumando.
     * @return La suma de a y b.
     */
    public int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Resta dos números enteros.
     * @param a Minuendo.
     * @param b Sustraendo.
     * @return La diferencia entre a y b.
     */
    public int restar(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dos números enteros.
     * @param a Primer factor.
     * @param b Segundo factor.
     * @return El producto de a y b.
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide dos números.
     * @param a Dividendo.
     * @param b Divisor.
     * @return El cociente de a y b.
     * @throws ArithmeticException si b es 0.
     */
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("División por cero");
        }
        return a / b;
    }

    // Pruebas unitarias

    @Test
    void testSumar() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.sumar(2, 3));
        assertEquals(-2, calc.sumar(-3, 1));
        assertEquals(138, calc.sumar(69, 69));
    }

    @Test
    void testRestar() {
        Calculadora calc = new Calculadora();
        assertEquals(7, calc.restar(10, 3));
        assertEquals(-5, calc.restar(0, 5));
        assertEquals(20, calc.restar(30, 10));
    }

    @Test
    void testMultiplicar() {
        Calculadora calc = new Calculadora();
        assertEquals(1170731198, calc.multiplicar(999001, 35566));
        assertEquals(-24, calc.multiplicar(6, -4));
        assertEquals(1000, calc.multiplicar(20, 50));
    }

    @Test
    void testDividir() {
        Calculadora calc = new Calculadora();
        assertEquals(2, calc.dividir(10, 5));
        assertEquals(-3, calc.dividir(-15, 5));
        assertThrows(ArithmeticException.class, () -> calc.dividir(100, 0));
    }

}


