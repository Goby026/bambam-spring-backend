package core.dev.bambam.service.jpa;

import core.dev.bambam.entity.Articulo;
import core.dev.bambam.repository.ArticuloRepository;
import core.dev.bambam.service.IArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloService implements IArticuloService {

    @Autowired
    private ArticuloRepository repository;

    @Override
    public List<Articulo> buscarTodo() {
        return this.repository.findAll();
    }

    @Override
    public Articulo guardar(Articulo articulo) {
        return this.repository.save(articulo);
    }

    @Override
    public void eliminar(int id) {
        this.repository.deleteById(id);
    }

}
