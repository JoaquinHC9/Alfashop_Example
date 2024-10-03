package alfashopback;

import alfashopback.model.Producto;
import alfashopback.service.CategoriaService;
import alfashopback.service.ProductoService;
import alfashopback.controller.ProductoController;
import alfashopback.model.Categoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductoTest {

    /*@Mock
    private ProductoService productoService;

    @Mock
    private CategoriaService categoriaService;

    private ProductoController productoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productoController = new ProductoController();
        productoController.setProductoService(productoService);
        productoController.setCategoriaService(categoriaService);
    }

    @Test
    void testListar() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto());
        when(productoService.findAll()).thenReturn(productos);

        List<Producto> resultado = productoController.listar();


        assertEquals(1, resultado.size());
        verify(productoService, times(1)).findAll();
    }

    @Test
    void testBuscarPorNombre() {

        String nombre = "Producto1";
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto());
        when(productoService.busquedaPorNombre(nombre)).thenReturn(productos);

        List<Producto> resultado = productoController.buscarPorNombre(nombre);

        assertEquals(1, resultado.size());
        verify(productoService, times(1)).busquedaPorNombre(nombre);
    }

    @Test
    void testBuscarPorNombreCategoria() {
        String nombreCategoria = "Categoría1";
        Integer idCategoria = 1;
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto());
        when(categoriaService.buscarPorNombre(nombreCategoria)).thenReturn(new Categoria());
        when(productoService.buscarPorIdCategoria(idCategoria)).thenReturn(productos);

        List<Producto> resultado = productoController.buscarPorNombreCategoria(nombreCategoria);

        assertEquals(1, resultado.size());
        verify(categoriaService, times(1)).buscarPorNombre(nombreCategoria);
        verify(productoService, times(1)).buscarPorIdCategoria(idCategoria);
    }

    @Test
    void testGetUnProductoPorNombre() {
        String nombre = "Producto1";
        Producto producto = new Producto();
        when(productoService.obtenerProducto(nombre)).thenReturn(producto);

        Producto resultado = productoController.getUnProductoPorNombre(nombre);

        assertEquals(producto, resultado);
        verify(productoService, times(1)).obtenerProducto(nombre);
    }

    @Test
    void testObtenerProducto() {
        Integer productoId = 1;
        Producto producto = new Producto();
        when(productoService.findById(productoId)).thenReturn(producto);

        Producto resultado = productoController.obtenerProducto(productoId);

        assertEquals(producto, resultado);
        verify(productoService, times(1)).findById(productoId);
    }

    @Test
    void testObtenerProductosPorCategoria() {
        Integer idCategoria = 1;
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto());
        when(productoService.buscarPorIdCategoria(idCategoria)).thenReturn(productos);
        List<Producto> resultado = productoController.obtenerProductosPorCategoria(idCategoria);

        assertEquals(1, resultado.size());
        verify(productoService, times(1)).buscarPorIdCategoria(idCategoria);
    }*/
}
