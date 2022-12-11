package pe.com.clbstoreweb.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.clbstoreweb.modelo.CategoriaEntity;
import pe.com.clbstoreweb.servicio.CategoriaService;

@Controller
public class CategoriaController {
    @Autowired
    private CategoriaService servicio;
    
    @GetMapping("/listarcategoria")
    public String PaginaListarCurso(Model modelo) {
        modelo.addAttribute("categorias", servicio.findAll());
        return "listarcategoria";
    }
    
    @GetMapping("/registrocategoria")
    public String MostrarFormularioRegistro() {
        //es el nombre que tendra la pagina web
        return "registrocategoria";
    }
    
    @ModelAttribute("categoria")
    public CategoriaEntity RegistroCategoria() {
        return new CategoriaEntity();
    }
    
    @PostMapping("/registrocategoria")
    public String RegistroCategoriaNuevo(
            @ModelAttribute("categoria") CategoriaEntity c) {
        servicio.add(c);
        return "redirect:/listarcategoria?correcto";
    }

//    @GetMapping("/actualizarcategoria/{id}")
//    public String MostrarFormularioActualizar(@PathVariable Long id,
//            Model modelo) {
//        modelo.addAttribute("categorias", servicio.findById(id));
//        return "actualizacategoria";
//    }
    
    @GetMapping("/actualizacategoria/{id}")
    public String MostrarFormularioActualiza(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("categorias", servicio.findById(id));
        return "actualizacategoria";
    }
    
    @PostMapping("/actualizacategoria/{id}")
    public String ActualizaCategoria(@PathVariable Long id,
            @ModelAttribute("categoria") CategoriaEntity c) {
        servicio.update(c);
        return "redirect:/listarcategoria?actualizo";
    }
}
