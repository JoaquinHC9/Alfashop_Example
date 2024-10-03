package alfashopback.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
    @Table(name = "carrito")
    public class Carrito {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_carrito")
        private Integer idCarrito;
        @Column(name = "pagado")
        private boolean pagado;

        // Getter y Setter para el estado de pago
        public boolean isPagado() {
            return pagado;
        }

        public void setPagado(boolean pagado) {
            this.pagado = pagado;
        }
        @ManyToMany
        @JoinTable(
                name = "carrito_producto",
                joinColumns = @JoinColumn(name = "id_carrito"),
                inverseJoinColumns = @JoinColumn(name = "id_producto")
        )
        private List<Producto> productos;

        @OneToOne
        @JoinColumn(name = "idComprador")
        private Comprador comprador;

        public Integer getIdCarrito() {
            return idCarrito;
        }

        public void setIdCarrito(Integer idCarrito) {
            this.idCarrito = idCarrito;
        }

        public List<Producto> getProductos() {
            return productos;
        }

        public void setProductos(List<Producto> productos) {
            this.productos = productos;
        }

        public void agregarProducto(Producto producto) {
            productos.add(producto);
        }

        public void eliminarProducto(Producto producto) {
            productos.remove(producto);
        }

        public void vaciarCarrito() {
            productos.clear();
        }

        public Comprador getComprador() {
            return comprador;
        }

        public void setComprador(Comprador comprador) {
            this.comprador = comprador;
        }
}
