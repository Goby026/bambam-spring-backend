package core.dev.bambam.service;

import core.dev.bambam.entity.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> buscarTodo();
    Cliente guardar(Cliente producto);
    void eliminar(int id);
}
