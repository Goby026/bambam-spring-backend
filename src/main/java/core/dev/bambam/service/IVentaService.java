package core.dev.bambam.service;

import core.dev.bambam.entity.Venta;

import java.util.List;

public interface IVentaService {
    List<Venta> buscarTodo();
    Venta guardar(Venta venta);
    void eliminar(int id);
}
