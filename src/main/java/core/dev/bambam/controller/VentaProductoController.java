package core.dev.bambam.controller;

import core.dev.bambam.entity.VentaProducto;
import core.dev.bambam.service.IVentaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class VentaProductoController {
    @Autowired
    private IVentaProductoService service;

    @GetMapping("/ventaProducto")
    private List<VentaProducto> listar(){
        return this.service.buscarTodo();
    }

    @GetMapping("/ventaProducto/{id}")
    public ResponseEntity<VentaProducto> obtenerPorId(@PathVariable("id") int id){
        return new ResponseEntity<>(this.service.obtener(id), HttpStatus.OK);
    }

    @PostMapping("/ventaProducto")
    private VentaProducto guardar(@RequestBody VentaProducto ventaProducto){
        return this.service.guardar(ventaProducto);
    }

    @PostMapping("/ventaProducto/saveall")
    private List<VentaProducto> guardarVarias(@RequestBody List<VentaProducto> ventaProductos){
        return this.service.guardarTodas(ventaProductos);
    }

    @PutMapping("/ventaProducto")
    private VentaProducto modificar(@RequestBody VentaProducto ventaProducto){
        return this.service.guardar(ventaProducto);
    }

    @DeleteMapping("/ventaProducto/{id}")
    private void borrar(@PathVariable("id") int id){
        this.service.eliminar(id);
    }

}
