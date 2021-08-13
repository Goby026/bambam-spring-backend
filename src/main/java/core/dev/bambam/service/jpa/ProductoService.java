package core.dev.bambam.service.jpa;

import core.dev.bambam.entity.Categoria;
import core.dev.bambam.entity.Producto;
import core.dev.bambam.repository.CategoriaRepository;
import core.dev.bambam.repository.ProductoRepository;
import core.dev.bambam.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Producto> buscarTodo() {
        return this.repository.findAll();
    }

    @Override
    public Producto obtener(int id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Producto guardar(Producto producto) {
        return this.repository.save(producto);
    }


    @Override
    public List<Producto> guardarTodas(List<Producto> productos) {
        return this.repository.saveAll(productos);
    }

    @Override
    public void eliminar(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        return this.repository.findByNombreContaining(nombre);
    }

    @Override
    public List<Producto> buscarPorCategoria(int idCategoria) {
        Categoria categoria = this.categoriaRepository.findById(idCategoria).orElse(null);
        return this.repository.findByCategoria(categoria);
    }

}
