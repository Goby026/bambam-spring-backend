package core.dev.bambam.service.jpa;

import core.dev.bambam.entity.Cliente;
import core.dev.bambam.repository.ClienteRepository;
import core.dev.bambam.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> buscarTodo() {
        return this.repository.findAll();
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return this.repository.save(cliente);
    }

    @Override
    public void eliminar(int id) {
        this.repository.deleteById(id);
    }

}
