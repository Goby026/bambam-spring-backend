package core.dev.bambam.controller;

import core.dev.bambam.entity.Articulo;
import core.dev.bambam.entity.Producto;
import core.dev.bambam.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductoController {

    @Autowired
    private IProductoService service;

    @GetMapping("/productos")
    public List<Producto> listar(){
        return this.service.buscarTodo();
    }

    @PostMapping("/productos")
    private Producto guardar(@RequestBody Producto producto){
        producto.setEstado(1);
        return this.service.guardar(producto);
    }

//    metodo para guardar varios articulos en un producto
    @PostMapping("/productos/create")
    private Producto crearProducto(@RequestBody Producto producto){

        Articulo articulo1 = new Articulo();
        articulo1.setId(2); //teclado
        Articulo articulo2 = new Articulo();
        articulo2.setId(3); //microfono

        producto.agregar(articulo1);
        producto.agregar(articulo2);

        return this.service.guardar(producto);
    }

    @PutMapping("/productos")
    private Producto modificar(@RequestBody Producto producto){
        return this.service.guardar(producto);
    }

    @DeleteMapping("/productos/{id}")
    private void borrar(@PathVariable("id") int id){
        this.service.eliminar(id);
    }
}
