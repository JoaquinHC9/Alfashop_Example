package alfashopback.service.impl;

import alfashopback.repository.CategoriaRepository;
import alfashopback.model.Categoria;
import alfashopback.service.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoriaImplementService implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public Categoria buscarPorNombre(String nombreCategoria) {
        return categoriaRepository.findByNombreCategoria(nombreCategoria);
    }
}
