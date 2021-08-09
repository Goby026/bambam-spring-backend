package core.dev.bambam.service;


import core.dev.bambam.entity.Categoria;

import java.util.List;

public interface ICategoriaService {
    List<Categoria> buscarTodo();
    Categoria guardar(Categoria articulo);
    void eliminar(int id);
}
