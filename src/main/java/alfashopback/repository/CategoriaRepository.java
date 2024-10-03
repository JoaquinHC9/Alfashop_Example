package alfashopback.repository;

import alfashopback.model.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
    Categoria findByNombreCategoria(String nombreCategoria);
}
