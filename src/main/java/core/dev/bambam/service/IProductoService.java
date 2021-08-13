package core.dev.bambam.service;

import core.dev.bambam.entity.Categoria;
import core.dev.bambam.entity.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> buscarTodo();
    Producto obtener(int id);
    Producto guardar(Producto producto);
    List<Producto> guardarTodas(List<Producto> productos);
    void eliminar(int id);
    List<Producto> buscarPorNombre(String nombre);
    List<Producto> buscarPorCategoria(int idCategoria);
}
