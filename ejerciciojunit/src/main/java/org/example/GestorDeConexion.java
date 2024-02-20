package org.example;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class GestorDeConexion {
    /**
     * Simula la apertura de una conexión a la base de datos.
     */
    public static void abrirConexion() {
        System.out.println("Conexión a la base de datos abierta.");
        // Lógica para abrir la conexión
    }

    /**
     * Simula el cierre de una conexión a la base de datos.
     */
    public static void cerrarConexion() {
        System.out.println("Conexión a la base de datos cerrada.");
        // Lógica para cerrar la conexión
    }
    @BeforeAll
    static void setUp() {
        GestorDeConexion.abrirConexion();
        // Lógica adicional de configuración antes de todas las pruebas
    }

    @AfterAll
    static void tearDown() {
        GestorDeConexion.cerrarConexion();
        // Lógica adicional de limpieza después de todas las pruebas
    }

    @Test
    void testAlgunaFuncionalidad() {
        // Aquí va tu prueba de funcionalidad
        assertTrue(true);
    }

    @Test
    void testOtraFuncionalidad() {
        // Aquí va otra prueba de funcionalidad
        assertEquals(2, 1 + 1);
    }

    // Agrega más pruebas según sea necesario

}
