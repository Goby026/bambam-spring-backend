package core.dev.bambam.service.jpa;

import core.dev.bambam.entity.Producto;
import core.dev.bambam.repository.ProductoRepository;
import core.dev.bambam.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository repository;

    @Override
    public List<Producto> buscarTodo() {
        return this.repository.findAll();
    }

    @Override
    public Producto guardar(Producto producto) {
        return this.repository.save(producto);
    }

    @Override
    public void eliminar(int id) {
        this.repository.deleteById(id);
    }
}
