package core.dev.bambam.service.jpa;

import core.dev.bambam.entity.Categoria;
import core.dev.bambam.repository.CategoriaRepository;
import core.dev.bambam.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public List<Categoria> buscarTodo() {
        return this.repository.findAll();
    }

    @Override
    public Categoria guardar(Categoria articulo) {
        return this.repository.save(articulo);
    }

    @Override
    public void eliminar(int id) {
        this.repository.deleteById(id);
    }
}
