package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class ClienteServicioWeb {
    private final ServicioWeb servicioWeb;

    public ClienteServicioWeb(ServicioWeb servicioWeb) {
        this.servicioWeb = servicioWeb;
    }

    /**
     * Obtiene información de usuario desde un servicio web.
     *
     * @param userId Identificador del usuario.
     * @return Información del usuario como una cadena de texto.
     */
    public String obtenerInformacionUsuario(String userId) {
        return servicioWeb.obtenerDatosUsuario(userId);
    }

    @Test
    void testObtenerInformacionUsuario() {
        // Creamos un mock del servicio web
        ServicioWeb mockServicioWeb = mock(ServicioWeb.class);

        // Configuramos el comportamiento del mock para un usuario dado
        String userId = "user123";
        when(mockServicioWeb.obtenerDatosUsuario(userId)).thenReturn("Información de usuario para user123");

        // Creamos una instancia de ClienteServicioWeb con el mock del servicio web
        ClienteServicioWeb cliente = new ClienteServicioWeb(mockServicioWeb);

        // Llamamos al método que queremos probar
        String informacionUsuario = cliente.obtenerInformacionUsuario(userId);

        // Verificamos que el resultado obtenido sea el esperado
        assertEquals("Información de usuario para user123", informacionUsuario);

        // Verificamos que el método del servicio web se haya llamado con el userId correcto
        verify(mockServicioWeb).obtenerDatosUsuario(userId);

        // Opcional: verificamos que no se hayan realizado otras llamadas al servicio web
        verifyNoMoreInteractions(mockServicioWeb);
    }

}

/**
 * Interfaz para el servicio web que será mockeado en las pruebas.
 */
interface ServicioWeb {
    String obtenerDatosUsuario(String userId);
}


