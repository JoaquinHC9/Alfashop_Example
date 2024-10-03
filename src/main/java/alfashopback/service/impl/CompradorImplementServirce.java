package alfashopback.service.Impl;

import java.util.List;
import alfashopback.repository.CompradorRepository;
import alfashopback.model.Comprador;
import alfashopback.service.CompradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompradorImplementServirce implements CompradorService {
    
    @Autowired
    private CompradorRepository compradorRepository;

    @Override
    public List<Comprador> findAll() {
        return (List<Comprador>) compradorRepository.findAll();
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
