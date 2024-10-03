package alfashopback.service.Impl;

import alfashopback.repository.CategoriaRepository;
import alfashopback.model.Categoria;
import alfashopback.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaImplementService implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscarPorNombre(String nombreCategoria) {
        return categoriaRepository.findByNombreCategoria(nombreCategoria);
    }
}
