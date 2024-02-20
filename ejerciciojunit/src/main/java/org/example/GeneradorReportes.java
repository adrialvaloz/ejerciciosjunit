package org.example;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class GeneradorReportes {
    private GeneradorReportes generador = new GeneradorReportes();

    /**
     * Genera un reporte basado en una lista de datos.
     * @param datos Lista de datos para incluir en el reporte.
     * @return El reporte generado como una cadena de texto.
     */
    public String generarReporte(List<String> datos) {
        if (datos == null || datos.isEmpty()) {
            return "Reporte vacío";
        }

        StringBuilder reporte = new StringBuilder("Reporte:\n");
        for (String dato : datos) {
            reporte.append("- ").append(dato).append("\n");
        }
        return reporte.toString();
    }
    @TestFactory
    Stream<DynamicTest> testGenerarReporte() {
        List<String> datos1 = Arrays.asList("Dato 1", "Dato 2", "Dato 3");
        List<String> datos2 = Arrays.asList("Reporte 1", "Reporte 2", "Reporte 3");
        List<String> datos3 = Arrays.asList("Java", "JUnit", "Dinámico");
        List<String> datos4 = Arrays.asList(); // Lista vacía

        // Definimos las pruebas dinámicamente
        return Stream.of(
                DynamicTest.dynamicTest("Reporte con datos 1", () -> {
                    String expected = "Reporte:\n- Dato 1\n- Dato 2\n- Dato 3\n";
                    assertEquals(expected, generador.generarReporte(datos1));
                }),
                DynamicTest.dynamicTest("Reporte con datos 2", () -> {
                    String expected = "Reporte:\n- Reporte 1\n- Reporte 2\n- Reporte 3\n";
                    assertEquals(expected, generador.generarReporte(datos2));
                }),
                DynamicTest.dynamicTest("Reporte con datos 3", () -> {
                    String expected = "Reporte:\n- Java\n- JUnit\n- Dinámico\n";
                    assertEquals(expected, generador.generarReporte(datos3));
                }),
                DynamicTest.dynamicTest("Reporte vacío", () -> {
                    String expected = "Reporte vacío";
                    assertEquals(expected, generador.generarReporte(datos4));
                })
        );
    }
}
