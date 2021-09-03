package core.dev.bambam.service;

import java.util.List;

public interface IService<Param> {
    List<Param> buscarTodo();
    Param obtenerNombre(String nombre);
    Param guardar(Param param);
    List<Param> guardarTodas(List<Param> params);
    void eliminar(int id);
    List<Param> buscarNombre(String nombre);
}
