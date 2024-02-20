package org.example;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class ConversorTemperatura {
    private ConversorTemperatura conversor = new ConversorTemperatura();

    @ParameterizedTest
    @CsvSource({
            "0, 32",   // 0°C equivale a 32°F
            "100, 212",  // 100°C equivale a 212°F
            "-40, -40"  // -40°C equivale a -40°F
    })
    void testCelsiusAFahrenheit(String celsiusStr, String expectedFahrenheitStr) {
        double celsius = Double.parseDouble(celsiusStr);
        double expectedFahrenheit = Double.parseDouble(expectedFahrenheitStr);

        double actualFahrenheit = conversor.testCelsiusAFahrenheit(celsius);
        assertEquals(expectedFahrenheit, actualFahrenheit, 0.0001); // Comparamos con un delta de tolerancia
    }

    private double testCelsiusAFahrenheit(double celsius) {
        return 0;
    }

    @ParameterizedTest
    @CsvSource({
            "32, 0",   // 32°F equivale a 0°C
            "212, 100",  // 212°F equivale a 100°C
            "-40, -40"  // -40°F equivale a -40°C
    })
    void testFahrenheitACelsius(String fahrenheitStr, String expectedCelsiusStr) {
        double fahrenheit = Double.parseDouble(fahrenheitStr);
        double expectedCelsius = Double.parseDouble(expectedCelsiusStr);

        double actualCelsius = conversor.testFahrenheitACelsius(fahrenheit);
        assertEquals(expectedCelsius, actualCelsius, 0.0001); // Comparamos con un delta de tolerancia
    }

    private double testFahrenheitACelsius(double fahrenheit) {
        return 0;
    }
}
