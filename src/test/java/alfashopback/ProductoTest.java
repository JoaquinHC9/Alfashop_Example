package alfashopback;

import alfashopback.model.Producto;
import alfashopback.model.Categoria;
import alfashopback.service.CategoriaService;
import alfashopback.service.ProductoService;
import alfashopback.controller.ProductoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductoTest {

    @Mock
    private ProductoService productoService;

    @Mock
    private CategoriaService categoriaService;

    @InjectMocks
    private ProductoController productoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListar() {
        // Preparamos la lista simulada de productos
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto()); // Aquí puedes configurar mejor los productos si lo necesitas

        // Simulamos el comportamiento del servicio
        when(productoService.findAll()).thenReturn(productos);

        // Ejecutamos el método del controlador
        List<Producto> resultado = productoController.listar();

        // Validamos los resultados
        assertEquals(1, resultado.size());
        verify(productoService, times(1)).findAll();
    }

    @Test
    void testBuscarPorNombre() {
        // Preparamos los datos de prueba
        String nombre = "Producto1";
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto());

        // Simulamos el comportamiento del servicio
        when(productoService.busquedaPorNombre(nombre)).thenReturn(productos);

        // Ejecutamos el método del controlador
        List<Producto> resultado = productoController.buscarPorNombre(nombre);

        // Validamos los resultados
        assertEquals(1, resultado.size());
        verify(productoService, times(1)).busquedaPorNombre(nombre);
    }

    @Test
    void testBuscarPorNombreCategoria() {
        // Datos de prueba
        String nombreCategoria = "Categoría1";
        Integer idCategoria = 1;
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto());

        // Simulamos el comportamiento de los servicios
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(idCategoria);
        when(categoriaService.buscarPorNombre(nombreCategoria)).thenReturn(categoria);
        when(productoService.buscarPorIdCategoria(idCategoria)).thenReturn(productos);

        // Ejecutamos el método del controlador
        List<Producto> resultado = productoController.buscarPorNombreCategoria(nombreCategoria);

        // Validamos los resultados
        assertEquals(1, resultado.size());
        verify(categoriaService, times(1)).buscarPorNombre(nombreCategoria);
        verify(productoService, times(1)).buscarPorIdCategoria(idCategoria);
    }

    @Test
    void testGetUnProductoPorNombre() {
        // Datos de prueba
        String nombre = "Producto1";
        Producto producto = new Producto();

        // Simulamos el comportamiento del servicio
        when(productoService.obtenerProducto(nombre)).thenReturn(producto);

        // Ejecutamos el método del controlador
        Producto resultado = productoController.getUnProductoPorNombre(nombre);

        // Validamos los resultados
        assertEquals(producto, resultado);
        verify(productoService, times(1)).obtenerProducto(nombre);
    }

    @Test
    void testObtenerProducto() {
        // Datos de prueba
        Integer productoId = 1;
        Producto producto = new Producto();

        // Simulamos el comportamiento del servicio
        when(productoService.findById(productoId)).thenReturn(producto);

        // Ejecutamos el método del controlador
        Producto resultado = productoController.obtenerProducto(productoId);

        // Validamos los resultados
        assertEquals(producto, resultado);
        verify(productoService, times(1)).findById(productoId);
    }

    @Test
    void testObtenerProductosPorCategoria() {
        // Datos de prueba
        Integer idCategoria = 1;
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto());

        // Simulamos el comportamiento del servicio
        when(productoService.buscarPorIdCategoria(idCategoria)).thenReturn(productos);

        // Ejecutamos el método del controlador
        List<Producto> resultado = productoController.obtenerProductosPorCategoria(idCategoria);

        // Validamos los resultados
        assertEquals(1, resultado.size());
        verify(productoService, times(1)).buscarPorIdCategoria(idCategoria);
    }
}
