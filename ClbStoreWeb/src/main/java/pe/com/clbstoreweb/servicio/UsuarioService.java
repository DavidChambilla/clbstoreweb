package pe.com.clbstoreweb.servicio;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;
import pe.com.clbstoreweb.dto.UsuarioRegistroDTO;
import pe.com.clbstoreweb.modelo.UsuarioEntity;

public interface UsuarioService extends UserDetailsService {

    UsuarioEntity add(UsuarioRegistroDTO udto);

    List<UsuarioEntity> findAll();
}