package core.dev.bambam.repository;

import core.dev.bambam.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {
    List<Articulo> findByNombreContaining(String nombre);
}
