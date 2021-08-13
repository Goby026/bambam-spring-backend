package core.dev.bambam.controller;

import core.dev.bambam.entity.Categoria;
import core.dev.bambam.entity.Producto;
import core.dev.bambam.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return this.service.guardar(producto);
    }

//    metodo para guardar varios productos
    @PostMapping("/productos/create")
    private List<Producto> crearProducto(@RequestBody List<Producto> productos){
        return this.service.guardarTodas(productos);
    }

    @PutMapping("/productos")
    private Producto modificar(@RequestBody Producto producto){
        return this.service.guardar(producto);
    }

    @DeleteMapping("/productos/{id}")
    private void borrar(@PathVariable("id") int id){
        this.service.eliminar(id);
    }

    @GetMapping("productos/search/prod/{prod}")
    private List<Producto> buscarPorProducto(@PathVariable("prod") String producto){
        return service.buscarPorNombre(producto);
    }

    @GetMapping("productos/search/cat/{id}")
    public ResponseEntity<List<Producto>> buscarPorCategoria(@PathVariable("id") int id ){
        return new ResponseEntity<>(
                this.service.buscarPorCategoria(id),
                HttpStatus.OK);
    }
}
