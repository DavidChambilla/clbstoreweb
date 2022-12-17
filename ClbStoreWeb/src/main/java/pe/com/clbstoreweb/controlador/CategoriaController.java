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
import pe.com.clbstoreweb.modelo.CategoriaEntity;
import pe.com.clbstoreweb.repositorio.CategoriaDisable;
import pe.com.clbstoreweb.servicio.CategoriaService;

@Controller
public class CategoriaController {

    @Autowired
    private CategoriaService servicio;
    
    @Autowired
    private CategoriaDisable disable;

    @GetMapping("/listarcategoria")
    public String PaginaListarCategoria(Model modelo) {
        modelo.addAttribute("categorias", servicio.findAllCustom());
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
    
    @GetMapping("/eliminacategoria/{id}")
    public String EliminaCategoria(@PathVariable Long id, Model modelo) {
        CategoriaEntity objcategoria = servicio.findById(id);
        servicio.delete(objcategoria);
        return "redirect:/listarcategoria?elimino";
    }
    
    @GetMapping("/habilitarcategoria")
    public String PaginaHabilitarCategoria(Model modelo) {
        modelo.addAttribute("categorias", disable.findAllDisable());
        return "habilitarcategoria";
    }
    
    @GetMapping("/habilitacategoria/{id}")
    public String HabilitaCcategoria(@PathVariable Long id, Model modelo) {
        CategoriaEntity objcategoria = servicio.findById(id);
        servicio.enable(objcategoria);
        return "redirect:/listarcategoria?habilito";
    }


}
