package alfashopback.service.Impl;

import java.util.List;
import alfashopback.repository.ProductoRepository;
import alfashopback.model.Producto;
import alfashopback.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoImplementService implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public List<Producto> findAll() {
        return (List<Producto>) productoRepository.findAll();
    }
    @Override
    @Transactional(readOnly = true)
    public Producto findById(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }
    @Override
    public List<Producto> busquedaPorNombre(String nombre) {
        return productoRepository.findByNombreContaining(nombre);
    }
    @Override
    public List<Producto> buscarPorIdCategoria(Integer idCategoria) {
        return productoRepository.findByIdCategoria(idCategoria);
    }
    @Override
    public Producto obtenerProducto(String nombre){
        return productoRepository.findByNombre(nombre);
    }
}
