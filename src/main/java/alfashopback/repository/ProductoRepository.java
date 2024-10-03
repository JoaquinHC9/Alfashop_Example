package alfashopback.repository;

import alfashopback.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    List<Producto> findByNombreContaining(String nombre);
    List<Producto> findByIdCategoria(Integer idCategoria);
    Producto findByNombre(String nombre);
}
