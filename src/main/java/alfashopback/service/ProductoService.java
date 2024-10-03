package alfashopback.service;

import java.util.List;
import alfashopback.model.Producto;

public interface ProductoService {
    public List<Producto> findAll();
    public Producto findById(Integer id);
    List<Producto> busquedaPorNombre(String nombre);
    List<Producto> buscarPorIdCategoria(Integer idCategoria);
    public Producto obtenerProducto(String nombre);
}
