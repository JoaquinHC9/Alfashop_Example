package alfashopback.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "comprador")
public class Comprador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comprador")
    private Integer idComprador;
    
    @Column(name = "correo")
    private String correo;

    @Column(name = "contrasenia")
    private String contrasenia;
        
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "fechaNacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {return apellidos;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Integer getIdComprador() {return idComprador;}

    public void setIdComprador(Integer idComprador) {this.idComprador = idComprador;}
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
