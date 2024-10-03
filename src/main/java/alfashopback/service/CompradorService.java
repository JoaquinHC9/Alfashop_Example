package alfashopback.service;

import java.util.List;

import alfashopback.model.Comprador;


public interface CompradorService {
    public List<Comprador> findAll();
    public Comprador save(Comprador comprador);
    public Comprador findById(Integer idUsuario);
    public void delete(Integer idUsuario);
    public Comprador findByCorreo(String correo);
}
