
package pe.com.clbstoreweb.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="ProductoEntity")
@Table(name="Producto")
public class ProductoEntity implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @Column(name="codpro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column(name="nompro")
    private String nombre;
    @Column(name="descri")
    private String descripcion;
    @Column(name="stock")
    private int stock;
    @Column(name="prec")
    private double precio;
    @Column(name="estpro")
    private boolean estado;
    
    //@ManyToOne define la relacion de muchos a uni
    @ManyToOne
    //@JoinColumn define el campo que genera la clave foranea
    @JoinColumn(name="codcat", nullable = false)
    private CategoriaEntity categoria;
}
