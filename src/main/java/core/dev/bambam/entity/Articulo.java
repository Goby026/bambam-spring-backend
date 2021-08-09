package core.dev.bambam.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "articulos")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String  descripcion;
    private int  estado;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp dateCreated;

    @UpdateTimestamp
    private Timestamp lastModified;

}
