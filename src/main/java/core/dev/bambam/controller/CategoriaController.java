package core.dev.bambam.controller;

import core.dev.bambam.entity.Categoria;
import core.dev.bambam.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoriaController {

    @Autowired
    private ICategoriaService service;

    @GetMapping("/categorias")
    public List<Categoria> listar(){
        return this.service.buscarTodo();
    }

    @PostMapping("/categorias")
    private Categoria guardar(@RequestBody Categoria categoria){
        categoria.setEstado(1);
        return this.service.guardar(categoria);
    }

    @PutMapping("/categorias")
    private Categoria modificar(@RequestBody Categoria categoria){
        return this.service.guardar(categoria);
    }

    @DeleteMapping("/categorias/{id}")
    private void borrar(@PathVariable("id") int id){
        this.service.eliminar(id);
    }
}
