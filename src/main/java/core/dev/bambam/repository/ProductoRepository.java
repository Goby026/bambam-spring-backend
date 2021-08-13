package core.dev.bambam.repository;

import core.dev.bambam.entity.Categoria;
import core.dev.bambam.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByNombreContaining(String producto);
    List<Producto> findByCategoria(Categoria categoria);
}
