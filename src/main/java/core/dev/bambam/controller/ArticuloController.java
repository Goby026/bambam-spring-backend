package core.dev.bambam.controller;

import core.dev.bambam.entity.Articulo;
import core.dev.bambam.entity.Cliente;
import core.dev.bambam.entity.DetallesCliente;
import core.dev.bambam.service.IArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ArticuloController {

    @Autowired
    //private ArticuloService service;
    private IArticuloService service;

    @GetMapping("/articulos")
    public List<Articulo> listar(){
        return this.service.buscarTodo();
    }

    @PostMapping("/articulos")
    private Articulo guardar(@RequestBody Articulo articulo){
        articulo.setEstado(1);
        return this.service.guardar(articulo);
    }

    @PostMapping("/articulos/create")
    private List<Articulo> guardarTodas(@RequestBody List<Articulo> articulos){
        return this.service.guardarTodas(articulos);
    }

    @PutMapping("/articulos")
    private Articulo modificar(@RequestBody Articulo articulo){
        return this.service.guardar(articulo);
    }

    @DeleteMapping("/articulos/{id}")
    private void borrar(@PathVariable("id") int id){
        this.service.eliminar(id);
    }

    @GetMapping("/articulos/search/{nombre}")
    private List<Articulo> buscarPorNombre(@PathVariable("nombre") String nombre){
        return this.service.buscarNombre(nombre);
    }

}
