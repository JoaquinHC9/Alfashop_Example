package alfashopback;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CompradorTest {

    /*@Mock
    private CompradorService compradorService;

    @Mock
    private Autenticacion autenticacion;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private CompradorController compradorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        compradorController = new CompradorController();
        compradorController.setCompradorService(compradorService);
        compradorController.setAutenticacion(autenticacion);
        compradorController.setBCryptPasswordEncoder(bCryptPasswordEncoder);
    }

    @Test
    void testListar() {
        List<Comprador> compradores = new ArrayList<>();
        compradores.add(new Comprador());
        when(compradorService.findAll()).thenReturn(compradores);

        List<Comprador> resultado = compradorController.listar();

        assertEquals(1, resultado.size());
        verify(compradorService, times(1)).findAll();
    }

    @Test
    void testGuardar_Exitoso() {
        Comprador comprador = new Comprador();
        comprador.setCorreo("correo@example.com");
        comprador.setContrasenia("password");
        when(autenticacion.verificarCorreoExistente(comprador.getCorreo())).thenReturn(false);
        when(bCryptPasswordEncoder.encode(comprador.getContrasenia())).thenReturn("hashedPassword");
        when(compradorService.save(comprador)).thenReturn(comprador);

        ResponseEntity<Object> respuesta = compradorController.guardar(comprador);

        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());
        assertEquals(comprador, respuesta.getBody());
        verify(autenticacion, times(1)).verificarCorreoExistente(comprador.getCorreo());
        verify(bCryptPasswordEncoder, times(1)).encode(comprador.getContrasenia());
        verify(compradorService, times(1)).save(comprador);
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

    /*@Test
    void testGetUnUsuario() {
        Integer id = 1;
        Comprador comprador = new Comprador();
        when(compradorService.findById(id)).thenReturn(comprador);

        Comprador resultado = compradorController.getUnUsuario(id);

        assertEquals(comprador, resultado);
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

    @Test
    void testLogin_CredencialesCorrectas() {
        String correo = "correo@example.com";
        String contrasenia = "password";
        String hashedPassword = "hashedPassword";
        Comprador comprador = new Comprador();
        comprador.setCorreo(correo);
        comprador.setContrasenia(hashedPassword);
        when(compradorService.findByCorreo(correo)).thenReturn(comprador);
        when(bCryptPasswordEncoder.matches(contrasenia, hashedPassword)).thenReturn(true);

        ResponseEntity<String> respuesta = compradorController.login(comprador);

        assertEquals(HttpStatus.OK, respuesta.getStatusCode());
        assertEquals("Inicio de sesión exitoso para el usuario", respuesta.getBody());
        assertEquals(correo, respuesta.getHeaders().get("correo").get(0));
        verify(compradorService, times(1)).findByCorreo(correo);
        verify(bCryptPasswordEncoder, times(1)).matches(contrasenia, hashedPassword);
    }

    @Test
    void testLogin_CredencialesIncorrectas() {
        String correo = "correo@example.com";
        String contrasenia = "password";
        Comprador comprador = new Comprador();
        when(compradorService.findByCorreo(correo)).thenReturn(comprador);

        ResponseEntity<String> respuesta = compradorController.login(comprador);

        assertEquals(HttpStatus.UNAUTHORIZED, respuesta.getStatusCode());
        assertEquals("Credenciales de inicio de sesión incorrectas", respuesta.getBody());
        assertNull(respuesta.getHeaders().get("correo"));
        verify(compradorService, times(1)).findByCorreo(correo);
        verify(bCryptPasswordEncoder, never()).matches(anyString(), anyString());
    }*/

}
