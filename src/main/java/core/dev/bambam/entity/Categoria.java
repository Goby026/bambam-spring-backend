package core.dev.bambam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "categorias")
public class Categoria{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String  descripcion;
    private int  estado;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
    private List<Producto> productos;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp date_created;

    @UpdateTimestamp
    private Timestamp last_modified;
}
