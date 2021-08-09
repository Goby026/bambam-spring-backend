package core.dev.bambam.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String  descripcion;
    private int  estado;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp dateCreated;

    @UpdateTimestamp
    private Timestamp lastModified;
}
