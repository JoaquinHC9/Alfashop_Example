package alfashopback.service.impl;

import alfashopback.repository.CarritoRepository;
import alfashopback.model.Carrito;
import alfashopback.service.CarritoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CarritoImplementService implements CarritoService {

    private final CarritoRepository carritoRepository;
    @Override
    @Transactional(readOnly = true)
    public Carrito findById(Integer id) {
        return carritoRepository.findById(id).orElse(null);
    }
    @Override
    public Carrito guardarCarrito(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    @Override
    public void eliminarCarrito(Carrito carrito) {
        carritoRepository.delete(carrito);
    }
}
