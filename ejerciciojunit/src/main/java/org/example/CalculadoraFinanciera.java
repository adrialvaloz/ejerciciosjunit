package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CalculadoraFinanciera {
    /**
     * Calcula el interés compuesto dado un capital principal, la tasa de interés anual,
     * el número de veces que el interés se compone por año, y el número de años.
     *
     * @param principal El capital principal.
     * @param tasaInteres La tasa de interés anual en forma decimal (ejemplo: 0.05 para 5%).
     * @param numeroCompuestos El número de veces que el interés se compone por año.
     * @param años El número de años.
     * @return El monto acumulado con interés compuesto.
     */
    public double calcularInteresCompuesto(double principal, double tasaInteres, int numeroCompuestos, int años) {
        return principal * Math.pow(1 + (tasaInteres / numeroCompuestos), numeroCompuestos * años);
    }

    /**
     * Calcula el Valor Presente Neto (VPN) de una serie de flujos de caja futuros, dados
     * la tasa de descuento y los flujos de caja esperados (incluyendo la inversión inicial
     * como el primer flujo de caja negativo).
     *
     * @param tasaDescuento La tasa de descuento en forma decimal.
     * @param flujosCaja Un arreglo que contiene los flujos de caja, donde el primer elemento es la inversión inicial.
     * @return El Valor Presente Neto (VPN) de los flujos de caja dados.
     */
    public double calcularVPN(double tasaDescuento, double[] flujosCaja) {
        double vpn = 0;
        for (int i = 0; i < flujosCaja.length; i++) {
            vpn += flujosCaja[i] / Math.pow(1 + tasaDescuento, i);
        }
        return vpn;
    }

    private static final double ERROR_ACEPTABLE = 0.0001; // Error aceptable para comparaciones de punto flotante

    @Test
    void testCalcularInteresCompuesto() {
        CalculadoraFinanciera calculadora = new CalculadoraFinanciera();

        // Casos de prueba con valores conocidos
        assertEquals(1102.5, calculadora.calcularInteresCompuesto(1000, 0.05, 2, 1), ERROR_ACEPTABLE);
        assertEquals(1215.50625, calculadora.calcularInteresCompuesto(1000, 0.05, 4, 2), ERROR_ACEPTABLE);
        assertEquals(1310.79625, calculadora.calcularInteresCompuesto(1000, 0.06, 4, 2), ERROR_ACEPTABLE);
        assertEquals(763.395, calculadora.calcularInteresCompuesto(500, 0.05, 1, 3), ERROR_ACEPTABLE);
        assertEquals(1505.5625, calculadora.calcularInteresCompuesto(1000, 0.03, 12, 1), ERROR_ACEPTABLE);

        // Casos de prueba con valores extremos
        assertEquals(1000, calculadora.calcularInteresCompuesto(1000, 0, 1, 10), ERROR_ACEPTABLE); // Tasa de interés 0%
        assertEquals(1000, calculadora.calcularInteresCompuesto(1000, 1, 1, 1), ERROR_ACEPTABLE); // Tasa de interés 100%
        assertEquals(1000000, calculadora.calcularInteresCompuesto(1000000, 0.1, 1, 1), ERROR_ACEPTABLE); // Un solo período
    }

    @Test
    void testCalcularVPN() {
        CalculadoraFinanciera calculadora = new CalculadoraFinanciera();

        // Casos de prueba con valores conocidos
        assertEquals(200.0, calculadora.calcularVPN(0.1, new double[]{-100, 100, 100}), ERROR_ACEPTABLE);
        assertEquals(207.611, calculadora.calcularVPN(0.1, new double[]{-100, 100, 100, 50}), ERROR_ACEPTABLE);
        assertEquals(300.0, calculadora.calcularVPN(0.1, new double[]{-100, 200, 200}), ERROR_ACEPTABLE);
        assertEquals(0.0, calculadora.calcularVPN(0.1, new double[]{0, 0, 0}), ERROR_ACEPTABLE);

        // Casos de prueba con valores extremos
        assertEquals(-100, calculadora.calcularVPN(0.1, new double[]{-100}), ERROR_ACEPTABLE); // Solo inversión inicial
        assertEquals(100, calculadora.calcularVPN(0.1, new double[]{100}), ERROR_ACEPTABLE); // Solo un flujo de caja positivo
        assertEquals(0, calculadora.calcularVPN(0.1, new double[]{0}), ERROR_ACEPTABLE); // Solo un flujo de caja cero
        assertEquals(0, calculadora.calcularVPN(0.1, new double[]{}), ERROR_ACEPTABLE); // Ningún flujo de caja
    }
}
