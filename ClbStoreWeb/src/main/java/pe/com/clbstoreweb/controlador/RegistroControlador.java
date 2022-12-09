package pe.com.clbstoreweb.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.com.clbstoreweb.servicio.UsuarioService;

@Controller
public class RegistroControlador {
    @Autowired
    private UsuarioService servicio;

    @GetMapping("/login")
    public String IniciarSesion() {
        return "login";
    }

    @GetMapping("/")
    public String PaginaInicio() {
        return "index";
    }
    
    @GetMapping("/listarusuario")
    public String PaginaListarUsuario(Model modelo){
        modelo.addAttribute("usuarios", servicio.findAll());
        return "listarusuario";
    }

}