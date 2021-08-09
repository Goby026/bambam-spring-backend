package core.dev.bambam.service;

import core.dev.bambam.entity.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> buscarTodo();
    Producto guardar(Producto producto);
    void eliminar(int id);
}
