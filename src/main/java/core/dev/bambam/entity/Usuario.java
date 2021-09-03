package core.dev.bambam.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30, unique = true)
    private String username;

    @Column(length = 60)
    private String password;

    private Boolean enabled;

//    @JsonIgnore
//    @OneToMany(mappedBy = "usuario")
//    private List<UsuarioPerfil> usuarioPerfiles;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Role> roles;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp date_created;

    @UpdateTimestamp
    private Timestamp last_modified;
}
