package alfashopback.controller;

import alfashopback.service.CarritoService;
import alfashopback.model.Carrito;
import alfashopback.model.Producto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/alfashop")
@AllArgsConstructor
public class CarritoController {
    private final CarritoService carritoServices;

    @DeleteMapping("/carrito/{carritoId}/productos/{productoId}")
    public Carrito eliminarProducto(@PathVariable("carritoId") Integer carritoId, @PathVariable("productoId") Integer productoId) {
        Carrito carrito = carritoServices.findById(carritoId);
        if (carrito != null) {
            List<Producto> productos = carrito.getProductos();
            productos.removeIf(p -> p.getIdProducto().equals(productoId));
            carrito.setProductos(productos);
            return carritoServices.guardarCarrito(carrito);
        }

        return null;
    }

    // Vaciar el carrito
    @DeleteMapping("/carrito/{carritoId}/vaciar")
    public Carrito vaciarCarrito(@PathVariable("carritoId") int carritoId) {
        Carrito carrito = carritoServices.findById(carritoId);
        if (carrito != null) {
            carrito.getProductos().clear();
            return carritoServices.guardarCarrito(carrito);
        }

        return null; // Manejar el caso de error o validación fallida
    }
    // Pagar el carrito
    @PostMapping("/carrito/{carritoId}/pagar")
    public String pagarCarrito(@PathVariable("carritoId") int carritoId) {
        Carrito carrito = carritoServices.findById(carritoId);
        if (carrito != null) {
            // Realizar lógica de pago y transacción aquí

            // Ejemplo: Marcar el carrito como pagado y vaciar los productos
            carrito.setPagado(true);
            carrito.getProductos().clear();
            carritoServices.guardarCarrito(carrito);
            return "Pago exitoso";
        }
        return "No se encontró el carrito"; // Manejar el caso de error o validación fallida
    }
    
}
