package pe.com.clbstoreweb.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.com.clbstoreweb.dto.UsuarioRegistroDTO;
import pe.com.clbstoreweb.modelo.RolEntity;
import pe.com.clbstoreweb.modelo.UsuarioEntity;
import pe.com.clbstoreweb.repositorio.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private BCryptPasswordEncoder PasswordEncoder;

    @Autowired
    private UsuarioRepository repositorio;

    @Override
    public UsuarioEntity add(UsuarioRegistroDTO udto) {
        UsuarioEntity objusuario = new UsuarioEntity();
        objusuario.setNombre(udto.getNombre());
        objusuario.setApellido(udto.getApellido());
        objusuario.setEmail(udto.getEmail());
        objusuario.setClave(PasswordEncoder.encode(udto.getClave()));
        objusuario.setRol(Arrays.asList(new RolEntity("ROLE_USER")));
        return repositorio.save(objusuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity objusuario = repositorio.findByEmail(username);
        if (objusuario == null) {
            throw new UsernameNotFoundException("Usuario o Clave no valido");
        }

        return new User(objusuario.getEmail(), objusuario.getClave(), mapearAutoridadRol(objusuario.getRol()));

    }

    public Collection<? extends GrantedAuthority> mapearAutoridadRol(Collection<RolEntity> roles) {
        return roles.stream().map(rol -> new SimpleGrantedAuthority(
                rol.getNombre())).collect(Collectors.toList());
    }

    @Override
    public List<UsuarioEntity> findAll() {
        return repositorio.findAll();
    }
}