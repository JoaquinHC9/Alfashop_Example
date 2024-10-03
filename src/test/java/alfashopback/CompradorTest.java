package alfashopback;

import alfashopback.controller.CompradorController;
import alfashopback.model.Comprador;
import alfashopback.service.AutenticacionService;
import alfashopback.service.CompradorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CompradorTest {

    @Mock
    private CompradorService compradorService;

    @Mock
    private AutenticacionService autenticacion;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private CompradorController compradorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        compradorController = new CompradorController(compradorService, autenticacion, bCryptPasswordEncoder);
    }

    @Test
    void testGuardar_CorreoExistente() {
        Comprador comprador = new Comprador();
        comprador.setCorreo("correo@example.com");

        when(autenticacion.verificarCorreoExistente(comprador.getCorreo())).thenReturn(true);

        ResponseEntity<Object> respuesta = compradorController.guardar(comprador);

        assertEquals(HttpStatus.CONFLICT, respuesta.getStatusCode());
        assertEquals("El correo electrónico ya está registrado", respuesta.getBody());
        verify(autenticacion, times(1)).verificarCorreoExistente(comprador.getCorreo());
        verify(bCryptPasswordEncoder, never()).encode(anyString());
        verify(compradorService, never()).save(comprador);
    }

    @Test
    void testGetUnUsuario() {
        Integer id = 1;
        Comprador comprador = new Comprador();
        when(compradorService.findById(id)).thenReturn(comprador);

        ResponseEntity<Comprador> resultado = compradorController.getUnUsuario(id);

        assertEquals(HttpStatus.OK, resultado.getStatusCode());
        assertEquals(comprador, resultado.getBody());
        verify(compradorService, times(1)).findById(id);
    }

    @Test
    void testModificar() {
        Integer id = 1;
        Comprador comprador = new Comprador();
        comprador.setNombres("John");
        when(compradorService.findById(id)).thenReturn(comprador);
        when(compradorService.save(comprador)).thenReturn(comprador);

        Comprador resultado = compradorController.modificar(comprador, id);

        assertEquals(comprador, resultado);
        assertEquals("John", resultado.getNombres());
        verify(compradorService, times(1)).findById(id);
        verify(compradorService, times(1)).save(comprador);
    }

    @Test
    void testEliminar() {
        Integer id = 1;

        compradorController.eliminar(id);

        verify(compradorService, times(1)).delete(id);
    }


}
