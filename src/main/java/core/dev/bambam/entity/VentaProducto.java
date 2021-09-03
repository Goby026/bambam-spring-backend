package core.dev.bambam.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "ventaproducto")
public class VentaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idventa")
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "idproducto")
    private Producto producto;

    private Double precioUnitario;
    private int cantidad;
    private Double dcto;
    private int estado;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp date_created;

    @UpdateTimestamp
    private Timestamp last_modified;
}
