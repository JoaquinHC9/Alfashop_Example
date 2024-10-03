
package alfashopback.service;

import alfashopback.model.Comprador;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService {

    private CompradorService compradorService;

    public AutenticacionService(CompradorService compradorService){
        this.compradorService = compradorService;
    }
    public boolean verificarCorreoExistente(String correo) {
        Comprador compradorExistente = compradorService.findByCorreo(correo);
        return compradorExistente != null;
    }
}
