package core.dev.bambam.service.jpa;

import core.dev.bambam.entity.Usuario;
import core.dev.bambam.repository.UsuarioRepository;
import core.dev.bambam.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements IService<Usuario> {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<Usuario> buscarTodo() {
        return this.repository.findAll();
    }

    public Usuario obtenerNombre(String nombre){
        return this.repository.findByUsername(nombre);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return this.repository.save(usuario);
    }

    @Override
    public List<Usuario> guardarTodas(List<Usuario> usuarios) {
        return this.repository.saveAll(usuarios);
    }

    @Override
    public void eliminar(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Usuario> buscarNombre(String nombre) {
        return this.repository.findByUsernameContaining(nombre);
    }
}
