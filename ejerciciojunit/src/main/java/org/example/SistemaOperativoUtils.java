package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class SistemaOperativoUtils {
    /**
     * Devuelve el nombre del sistema operativo actual.
     * @return El nombre del sistema operativo.
     */
    public static String obtenerNombreSO() {
        return System.getProperty("os.name");
    }

    /**
     * Verifica si el sistema operativo actual es Windows.
     * @return true si el sistema operativo es Windows, false de lo contrario.
     */
    public static boolean esWindows() {
        return obtenerNombreSO().toLowerCase().contains("win");
    }

    /**
     * Verifica si el sistema operativo actual es MacOS.
     * @return true si el sistema operativo es MacOS, false de lo contrario.
     */
    public static boolean esMac() {
        return obtenerNombreSO().toLowerCase().contains("mac");
    }

    /**
     * Verifica si el sistema operativo actual es Linux.
     * @return true si el sistema operativo es Linux, false de lo contrario.
     */
    public static boolean esLinux() {
        return obtenerNombreSO().toLowerCase().contains("nux");
    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testEsWindows() {
        assertTrue(SistemaOperativoUtils.esWindows());
    }
}
