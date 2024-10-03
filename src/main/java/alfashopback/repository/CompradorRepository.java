
package alfashopback.repository;

import alfashopback.model.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompradorRepository extends JpaRepository<Comprador, Integer> {
    Comprador findByCorreo(String correo);
    
}
