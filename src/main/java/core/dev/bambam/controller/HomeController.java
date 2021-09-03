package core.dev.bambam.controller;

import core.dev.bambam.entity.Usuario;
import core.dev.bambam.service.jpa.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class HomeController {

    @Autowired
    private UsuarioService service;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public List<Usuario> welcome() {

        return this.service.buscarTodo();
    }

    @GetMapping("/factura/ver")
    public String ver(){
        return "Vista protegida de las facturas guardadas";
    }

    @GetMapping("/usuario/{usuario}")
    public List<Usuario> verPerfilesUsuario(@PathVariable("usuario") String nombre ){
        Usuario usuario = this.usuarioService.obtenerNombre(nombre);
        List<Usuario> usuarios = this.usuarioService.buscarNombre(nombre);

        return usuarios;
    }
}
