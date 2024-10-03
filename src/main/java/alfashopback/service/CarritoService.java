package alfashopback.service;

import alfashopback.model.Carrito;

public interface CarritoService {
    Carrito findById(Integer id);
    Carrito guardarCarrito(Carrito carrito);
    void eliminarCarrito(Carrito carrito);
}
