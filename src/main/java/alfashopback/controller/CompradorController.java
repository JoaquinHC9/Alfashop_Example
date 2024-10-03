package alfashopback.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import alfashopback.service.AutenticacionService;
import alfashopback.service.CompradorService;
import alfashopback.model.Comprador;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/alfashop")

public class CompradorController {

    private final CompradorService compradorService;
    private final AutenticacionService autenticacionService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public CompradorController(CompradorService compradorService, AutenticacionService autenticacionService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.compradorService = compradorService;
        this.autenticacionService = autenticacionService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //listar
    @GetMapping("/usuario")
    public List<Comprador> listar() {
        return compradorService.findAll();
    }

    //guardar
    @PostMapping("/usuario")
    public ResponseEntity<Object> guardar(@RequestBody Comprador tarea) {
        // Verificar si ya existe un usuario con el mismo correo electrónico
        boolean correoExistente = autenticacionService.verificarCorreoExistente(tarea.getCorreo());
        if (correoExistente) {
            // Retornar una respuesta de error indicando que el correo electrónico ya está en uso
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El correo electrónico ya está registrado");
        }

        // Encriptar la contraseña antes de guardarla
        String contrancriptada = bCryptPasswordEncoder.encode(tarea.getContrasenia());
        tarea.setContrasenia(contrancriptada);

        // Guardar el nuevo usuario si el correo electrónico no está en uso
        Comprador compradorGuardado = compradorService.save(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(compradorGuardado);
    }

    //get una tarea
    @GetMapping("/usuario/{id_usuario}")
    public ResponseEntity<Comprador> getUnUsuario(
            @PathVariable("id_usuario") Integer idUsuario
    ) {
        Comprador comprador = compradorService.findById(idUsuario);
        if (comprador != null) {
            return ResponseEntity.ok(comprador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/usuario/{id_usuario}")
    public Comprador modificar(
        @RequestBody Comprador comprador,
        @PathVariable("id_usuario") Integer id
    ) {
        Comprador compradorActual = compradorService.findById(id);
        compradorActual.setNombres(comprador.getNombres());
        compradorActual.setApellidos(comprador.getApellidos());
        compradorActual.setTelefono(comprador.getTelefono());
        compradorActual.setCorreo(comprador.getCorreo());
        compradorActual.setContrasenia(comprador.getContrasenia());
        compradorActual.setFechaNacimiento(comprador.getFechaNacimiento());
        return compradorService.save(compradorActual);
    }

    @DeleteMapping("/usuario/{id}")
    public void eliminar(@PathVariable Integer id) {
        compradorService.delete(id);
    }

    @PostMapping("/usuario/login")
    public ResponseEntity<String> login(@RequestBody Comprador comprador) {
        Comprador compradorAutenticado = compradorService.findByCorreo(comprador.getCorreo());
        if (compradorAutenticado != null) { //+1
            boolean contraseniaCorrecta = bCryptPasswordEncoder.matches(comprador.getContrasenia(), compradorAutenticado.getContrasenia());
            if (contraseniaCorrecta) { //+1
                Map<String, Object> response = new HashMap<>();
                response.put("message", "Inicio de sesión exitoso para el usuario");
                response.put("correo", compradorAutenticado.getCorreo());
                response.put("id", compradorAutenticado.getIdComprador());
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonResponse;
                try { //+1
                    jsonResponse = objectMapper.writeValueAsString(response);
                } catch (JsonProcessingException e) { //+1
                    jsonResponse = "Hubo un problema en sl servidor";
                }
                return ResponseEntity.ok().body(jsonResponse); //+1
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales de inicio de sesión incorrectas"); //+1
    }

}
