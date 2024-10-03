package alfashopback.service.impl;

import java.util.List;
import alfashopback.repository.CompradorRepository;
import alfashopback.model.Comprador;
import alfashopback.service.CompradorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CompradorImplementServirce implements CompradorService {
    
    private final CompradorRepository compradorRepository;

    @Override
    public List<Comprador> findAll() {
        return compradorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Comprador save(Comprador comprador) {
        return compradorRepository.save(comprador);
    }

    @Override
    @Transactional(readOnly = false)
    public Comprador findById(Integer idUsuario) {
        return compradorRepository.findById(idUsuario).orElse(null);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer idUsuario) {
        compradorRepository.deleteById(idUsuario);
    }

    @Override
    public Comprador findByCorreo(String correo) {
        return compradorRepository.findByCorreo(correo);
    }
    
}
