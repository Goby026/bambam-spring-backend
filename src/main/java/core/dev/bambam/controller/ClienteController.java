package core.dev.bambam.controller;

import core.dev.bambam.entity.Cliente;
import core.dev.bambam.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClienteController {

    @Autowired
    //private ArticuloService service;
    private IClienteService service;

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        return this.service.buscarTodo();
    }

    @PostMapping("/clientes")
    private Cliente guardar(@RequestBody Cliente cliente){
        return this.service.guardar(cliente);
    }

    @PutMapping("/clientes")
    private Cliente modificar(@RequestBody Cliente cliente){
        return this.service.guardar(cliente);
    }

    @DeleteMapping("/clientes/{id}")
    private void borrar(@PathVariable("id") int id){
        this.service.eliminar(id);
    }

}
