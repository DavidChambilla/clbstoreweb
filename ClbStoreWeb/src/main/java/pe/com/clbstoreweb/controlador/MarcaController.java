package pe.com.clbstoreweb.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.clbstoreweb.modelo.MarcaEntity;
import pe.com.clbstoreweb.repositorio.MarcaDisable;
import pe.com.clbstoreweb.servicio.MarcaService;

@Controller
public class MarcaController {

    @Autowired
    private MarcaService servicio;
    
    @Autowired
    private MarcaDisable disable;

    @GetMapping("/listarmarca")
    public String PaginaListarMarca(Model modelo) {
        modelo.addAttribute("marcas", servicio.findAllCustom());
        return "listarmarca";
    }

    @GetMapping("/registromarca")
    public String MostrarFormularioRegistro() {
        //es el nombre que tendra la pagina web
        return "registromarca";
    }

    @ModelAttribute("marca")
    public MarcaEntity RegistroMarca() {
        return new MarcaEntity();
    }

    @PostMapping("/registromarca")
    public String RegistroMarcaNuevo(
            @ModelAttribute("marca") MarcaEntity c) {
        servicio.add(c);
        return "redirect:/listarmarca?correcto";
    }

//    @GetMapping("/actualizarmarca/{id}")
//    public String MostrarFormularioActualizar(@PathVariable Long id,
//            Model modelo) {
//        modelo.addAttribute("marcas", servicio.findById(id));
//        return "actualizamarca";
//    }
    @GetMapping("/actualizamarca/{id}")
    public String MostrarFormularioActualiza(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("marcas", servicio.findById(id));
        return "actualizamarca";
    }
    
    @PostMapping("/actualizamarca/{id}")
    public String ActualizaMarca(@PathVariable Long id,
            @ModelAttribute("marca") MarcaEntity c) {
        servicio.update(c);
        return "redirect:/listarmarca?actualizo";
    }
    
    @GetMapping("/eliminamarca/{id}")
    public String EliminaMarca(@PathVariable Long id, Model modelo) {
        MarcaEntity objmarca = servicio.findById(id);
        servicio.delete(objmarca);
        return "redirect:/listarmarca?elimino";
    }
    
    @GetMapping("/habilitarmarca")
    public String PaginaHabilitarMarca(Model modelo) {
        modelo.addAttribute("marcas", disable.findAllDisable());
        return "habilitarmarca";
    }
    
    @GetMapping("/habilitamarca/{id}")
    public String HabilitaCmarca(@PathVariable Long id, Model modelo) {
        MarcaEntity objmarca = servicio.findById(id);
        servicio.enable(objmarca);
        return "redirect:/listarmarca?habilito";
    }


}
