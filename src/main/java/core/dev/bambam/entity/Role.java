package core.dev.bambam.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table( name = "authorities", uniqueConstraints = {@UniqueConstraint( columnNames = {"user_id", "authority"} )} )
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String authority;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp date_created;

    @UpdateTimestamp
    private Timestamp last_modified;
}
