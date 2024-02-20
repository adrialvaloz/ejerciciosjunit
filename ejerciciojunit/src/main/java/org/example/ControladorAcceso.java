package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControladorAcceso {

    private Map<String, String> usuariosYRoles;
    private ControladorAcceso controlador;

    public ControladorAcceso() {
        this.usuariosYRoles = new HashMap<>();
    }

    /**
     * Asigna un rol a un usuario.
     *
     * @param usuario El nombre de usuario.
     * @param rol El rol asignado al usuario.
     */
    public void asignarRolAUsuario(String usuario, String rol) {
        usuariosYRoles.put(usuario, rol);
    }

    /**
     * Verifica si un usuario tiene acceso a una funcionalidad basada en su rol.
     *
     * @param usuario El nombre de usuario.
     * @param funcionalidad La funcionalidad a la que se desea acceder.
     * @return true si el usuario tiene acceso a la funcionalidad; false en caso contrario.
     */
    public boolean verificarAcceso(String usuario, String funcionalidad) {
        String rol = usuariosYRoles.get(usuario);
        if (rol == null) {
            return false;
        }
        switch (rol) {
            case "ADMIN":
                return true; // Los admins tienen acceso a todo.
            case "EDITOR":
                return !funcionalidad.equals("GESTION_USUARIOS"); // Los editores no pueden gestionar usuarios.
            case "VISITANTE":
                return funcionalidad.equals("CONSULTA"); // Los visitantes solo pueden consultar.
            default:
                return false;
        }
    }
    @BeforeEach
    void setUp() {
        controlador = new ControladorAcceso();
    }

    @Test
    void testVerificarAcceso_Admin() {
        // Usuario con rol ADMIN
        controlador.asignarRolAUsuario("admin", "ADMIN");

        assertTrue(controlador.verificarAcceso("admin", "GESTION_USUARIOS"));
        assertTrue(controlador.verificarAcceso("admin", "CONSULTA"));
        assertTrue(controlador.verificarAcceso("admin", "EDICION_CONTENIDO"));
    }

    @Test
    void testVerificarAcceso_Editor() {
        // Usuario con rol EDITOR
        controlador.asignarRolAUsuario("editor", "EDITOR");

        assertTrue(controlador.verificarAcceso("editor", "EDICION_CONTENIDO"));
        assertFalse(controlador.verificarAcceso("editor", "GESTION_USUARIOS"));
        assertTrue(controlador.verificarAcceso("editor", "CONSULTA"));
    }

    @Test
    void testVerificarAcceso_Visitante() {
        // Usuario con rol VISITANTE
        controlador.asignarRolAUsuario("visitante", "VISITANTE");

        assertFalse(controlador.verificarAcceso("visitante", "EDICION_CONTENIDO"));
        assertFalse(controlador.verificarAcceso("visitante", "GESTION_USUARIOS"));
        assertTrue(controlador.verificarAcceso("visitante", "CONSULTA"));
    }

    @Test
    void testVerificarAcceso_SinRolAsignado() {
        // Usuario sin rol asignado
        assertFalse(controlador.verificarAcceso("sinrol", "CONSULTA"));
    }

    @Test
    void testVerificarAcceso_RolDesconocido() {
        // Usuario con rol desconocido
        controlador.asignarRolAUsuario("desconocido", "ROLE_XYZ");

        assertFalse(controlador.verificarAcceso("desconocido", "CONSULTA"));
    }
}
