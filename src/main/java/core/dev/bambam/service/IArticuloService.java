package core.dev.bambam.service;

import core.dev.bambam.entity.Articulo;

import java.util.List;

public interface IArticuloService {
    List<Articulo> buscarTodo();
    Articulo guardar(Articulo articulo);
    void eliminar(int id);
}
