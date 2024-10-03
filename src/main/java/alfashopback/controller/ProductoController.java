package alfashopback.controller;

import java.util.List;

import alfashopback.model.Categoria;
import alfashopback.service.CategoriaService;
import alfashopback.service.ProductoService;
import alfashopback.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/alfashop")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;

    //listar
    @GetMapping("/producto")
    public List<Producto> listar() {
        return productoService.findAll();
    }

    //get lista de productos por nombre
    @GetMapping("/producto/buscar/nombre/{nombre}")
    public List<Producto> buscarPorNombre(@PathVariable String nombre) {
        return productoService.busquedaPorNombre(nombre);
    }

    //obtener la categoria de los productos
    @GetMapping("/producto/buscar/{categoria}")
    public List<Producto> buscarPorNombreCategoria(@PathVariable("categoria") String nombreCategoria) {
        Integer idCategoria = getIdCategoriaPorNombre(nombreCategoria);
        return productoService.buscarPorIdCategoria(idCategoria);
    }

    //obtener la categoria el id de la categoria de un producto
    private Integer getIdCategoriaPorNombre(String nombreCategoria) {
        Categoria categoria = categoriaService.buscarPorNombre(nombreCategoria);
        if (categoria != null) {
            return categoria.getIdCategoria();
        }
        return null; // o manejo de error apropiado si no se encuentra la categoría
    }

    //get un producto por nombre
    @GetMapping("/producto/nombre/{nombre}")
    public Producto getUnProductoPorNombre(@PathVariable String nombre) {
        return productoService.obtenerProducto(nombre);
    }

    //get un producto por id
    @GetMapping("/producto/{productoId}")
    public Producto obtenerProducto(@PathVariable("productoId") Integer productoId) {
        return productoService.findById(productoId);
    }

    @GetMapping("/producto/categoria/{idCategoria}")
    public List<Producto> obtenerProductosPorCategoria(@PathVariable("idCategoria") Integer idCategoria) {
        return productoService.buscarPorIdCategoria(idCategoria);
    }
}
