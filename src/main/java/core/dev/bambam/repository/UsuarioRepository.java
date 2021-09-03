package core.dev.bambam.repository;

import core.dev.bambam.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByUsername(String username);
    List<Usuario> findByUsernameContaining(String username);
}
