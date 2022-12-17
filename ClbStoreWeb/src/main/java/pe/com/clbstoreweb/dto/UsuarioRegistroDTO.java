package pe.com.clbstoreweb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioRegistroDTO {

    private long codigo;
    private String nombre;
    private String apellido;
    private String email;
    private String clave;

    public UsuarioRegistroDTO(String nombre, String apellido, String email, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.clave = clave;
    }

    public UsuarioRegistroDTO(String email) {
        this.email = email;
    }
    
    
}