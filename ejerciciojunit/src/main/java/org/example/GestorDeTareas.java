package org.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestorDeTareas {
    private GestorDeTareas gestor;
    private List<String> tareas;

    public GestorDeTareas() {
        tareas = new ArrayList<>();
    }

    public void agregarTarea(String tarea) {
        tareas.add(tarea);
    }

    public boolean eliminarTarea(String tarea) {
        return tareas.remove(tarea);
    }

    public List<String> obtenerTareas() {
        return new ArrayList<>(tareas);
    }

    public void limpiarTareas() {
        tareas.clear();
    }

    @BeforeEach
    void setUp() {
        // Inicializar el gestor antes de cada prueba
        gestor = new GestorDeTareas();
        gestor.agregarTarea("Tarea 1");
        gestor.agregarTarea("Tarea 2");
        gestor.agregarTarea("Tarea 3");
    }

    @AfterEach
    void tearDown() {
        // Limpiar el gestor después de cada prueba
        gestor.limpiarTareas();
    }

    @Test
    void testAgregarTarea() {
        gestor.agregarTarea("Tarea 4");
        List<String> tareas = gestor.obtenerTareas();
        assertTrue(tareas.contains("Tarea 4"));
    }

    @Test
    void testEliminarTarea() {
        assertTrue(gestor.eliminarTarea("Tarea 2"));
        assertFalse(gestor.eliminarTarea("Tarea 5"));
    }

    @Test
    void testObtenerTareas() {
        List<String> tareas = gestor.obtenerTareas();
        assertEquals(3, tareas.size());
        assertTrue(tareas.contains("Tarea 1"));
        assertTrue(tareas.contains("Tarea 2"));
        assertTrue(tareas.contains("Tarea 3"));
    }

    @Test
    void testLimpiarTareas() {
        gestor.limpiarTareas();
        List<String> tareas = gestor.obtenerTareas();
        assertTrue(tareas.isEmpty());
    }
}
