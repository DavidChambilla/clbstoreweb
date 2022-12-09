package pe.com.clbstoreweb.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.clbstoreweb.dto.UsuarioRegistroDTO;
import pe.com.clbstoreweb.servicio.UsuarioService;

@Controller
@RequestMapping("/registrousuario")
public class RegistroUsuarioController {

    @Autowired
    private UsuarioService usuarioservicio;

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO RegistroUsuarioDTO() {
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String MostrarFormularioRegistro() {
        //es el nombre que tendra la pagina web
        return "registrousuario";
    }

    @PostMapping
    public String RegistroEmpleadoNuevo(
            @ModelAttribute("usuario") UsuarioRegistroDTO udto) {
        usuarioservicio.add(udto);
        return "redirect:/registrousuario?correcto";
    }

}