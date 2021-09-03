package core.dev.bambam.service;


import core.dev.bambam.entity.VentaProducto;

import java.util.List;

public interface IVentaProductoService {

    List<VentaProducto> buscarTodo();
    VentaProducto obtener(int id);
    VentaProducto guardar(VentaProducto ventaProducto);
    List<VentaProducto> guardarTodas(List<VentaProducto> ventasProductos);
    void eliminar(int id);

}
