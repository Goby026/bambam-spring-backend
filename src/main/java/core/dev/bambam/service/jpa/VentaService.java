package core.dev.bambam.service.jpa;

import core.dev.bambam.entity.Venta;
import core.dev.bambam.repository.VentaRepository;
import core.dev.bambam.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository repository;

    @Override
    public List<Venta> buscarTodo() {
        return this.repository.findAll();
    }

    @Override
    public Venta guardar(Venta venta) {
        return this.repository.save(venta);
    }

    @Override
    public void eliminar(int id) {
        this.repository.deleteById(id);
    }
}
