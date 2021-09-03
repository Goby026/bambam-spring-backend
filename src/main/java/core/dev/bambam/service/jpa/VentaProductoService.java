package core.dev.bambam.service.jpa;

import core.dev.bambam.entity.VentaProducto;
import core.dev.bambam.repository.VentaProductoRepository;
import core.dev.bambam.service.IVentaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaProductoService implements IVentaProductoService {

    @Autowired
    private VentaProductoRepository repository;

    @Override
    public List<VentaProducto> buscarTodo() {
        return this.repository.findAll();
    }

    @Override
    public VentaProducto obtener(int id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public VentaProducto guardar(VentaProducto ventaProducto) {
        return this.repository.save(ventaProducto);
    }

    @Override
    public List<VentaProducto> guardarTodas(List<VentaProducto> ventasProductos) {
        return this.repository.saveAll(ventasProductos);
    }

    @Override
    public void eliminar(int id) {
        this.repository.deleteById(id);
    }
}
