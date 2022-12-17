package pe.com.clbstoreweb.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "UsuarioEntity")
@Table(name = "usuario",
        uniqueConstraints
        = @UniqueConstraint(columnNames = "corusu"))
public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "codusu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name = "nomusu")
    private String nombre;
    @Column(name = "apeusu")
    private String apellido;
    @Column(name = "corusu")
    private String email;
    @Column(name = "clausu")
    private String clave;
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(
                    name = "codusu",
                    referencedColumnName = "codusu"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "codrol",
                    referencedColumnName = "codrol"
            )
    )
    private Collection<RolEntity> rol;

    public UsuarioEntity(String nombre, String apellido, String email, String clave, Collection<RolEntity> rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.clave = clave;
        this.rol = rol;
    }



}