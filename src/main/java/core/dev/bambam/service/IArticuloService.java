package core.dev.bambam.service;

import core.dev.bambam.entity.Articulo;

import java.util.List;

public interface IArticuloService {
    List<Articulo> buscarTodo();
    Articulo guardar(Articulo articulo);
    List<Articulo> guardarTodas(List<Articulo> articulos);
    void eliminar(int id);
    List<Articulo> buscarNombre(String nombre);
}
