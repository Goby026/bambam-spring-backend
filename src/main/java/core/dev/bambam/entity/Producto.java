package core.dev.bambam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name = "productos")
public class Producto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String unidad;
    private float precioVenta;
    private float precioCompra;
    private int cantidad;
    private String imagen;
    private int stockMinimo;
    private int stockMaximo;
    private int stockReal;
    private int estado;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "producto_articulo",
                joinColumns = @JoinColumn(name = "idproducto"),
                inverseJoinColumns = @JoinColumn(name = "idarticulo"))
    private List<Articulo> articulos;

    @ManyToOne()
    @JoinColumn(name = "idcategoria", nullable=false)
    private Categoria categoria;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp date_created;

    @UpdateTimestamp
    private Timestamp last_modified;

    @JsonIgnore
    @OneToMany(mappedBy = "producto")
    private List<VentaProducto> ventaProductos;


    public void agregar(Articulo articulo){
        if (this.articulos == null){
            this.articulos = new LinkedList<Articulo>();
        }
        this.articulos.add(articulo);
    }
}


//        articulos?: Articulo[],
//        categoria?: number
