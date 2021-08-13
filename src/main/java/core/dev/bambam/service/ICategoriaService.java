package core.dev.bambam.service;


import core.dev.bambam.entity.Categoria;

import java.util.List;

public interface ICategoriaService {
    List<Categoria> buscarTodo();
    Categoria obtener(int id);
    Categoria guardar(Categoria articulo);
    List<Categoria> guardarTodas(List<Categoria> categorias);
    void eliminar(int id);
}
