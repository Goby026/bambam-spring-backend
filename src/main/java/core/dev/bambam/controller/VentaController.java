package core.dev.bambam.controller;

import core.dev.bambam.entity.Venta;
import core.dev.bambam.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class VentaController {

    @Autowired
    private IVentaService service;

    @GetMapping("/ventas")
    private List<Venta> listar(){
        return this.service.buscarTodo();
    }

    @PostMapping("/ventas")
    private Venta guardar(@RequestBody Venta venta){
        return this.service.guardar(venta);
    }

    @PutMapping("/ventas")
    private Venta modificar(@RequestBody Venta venta){
        return this.service.guardar(venta);
    }

    @DeleteMapping("/ventas/{id}")
    private void borrar(@PathVariable("id") int id){
        this.service.eliminar(id);
    }
}
