package pe.com.clbstoreweb.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.clbstoreweb.modelo.ProductoEntity;
import pe.com.clbstoreweb.repositorio.ProductoDisable;
import pe.com.clbstoreweb.servicio.CategoriaService;
import pe.com.clbstoreweb.servicio.ProductoService;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService servicio;
    @Autowired
    private CategoriaService serviciocategoria;
    
    @Autowired
    private ProductoDisable disable;

    

    @GetMapping("/listarproducto")
    public String PaginaListarProducto(Model modelo) {
        modelo.addAttribute("productos", servicio.findAllCustom());
        return "listarproducto";
    }

    @GetMapping("/registroproducto")
    public String MostrarFormularioRegistro(Model modelo) {
        //es el nombre que tendra la pagina web
        modelo.addAttribute("categorias", serviciocategoria.findAll());
        return "registroproducto";
    }

    @ModelAttribute("producto")
    public ProductoEntity RegistroCategoria() {
        return new ProductoEntity();
    }

    @PostMapping("/registroproducto")
    public String RegistroProductoNuevo(
            @ModelAttribute("producto") ProductoEntity c) {
        servicio.add(c);
        return "redirect:/listarproducto?correcto";
    }
    
    
    
    @GetMapping("/actualizaproducto/{id}")
    public String MostrarFormularioActualiza(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("categorias", serviciocategoria.findAll());
        modelo.addAttribute("productos", servicio.findById(id));
        return "actualizaproducto";
    }

    @PostMapping("/actualizaproducto/{id}")
    public String ActualizaProducto(@PathVariable Long id,
            @ModelAttribute("producto") ProductoEntity c) {
        servicio.update(c);
        return "redirect:/listarproducto?actualizo";
    }

    @GetMapping("/eliminaproducto/{id}")
    public String EliminaProducto(@PathVariable Long id, Model modelo) {
        ProductoEntity objproducto = servicio.findById(id);
        servicio.delete(objproducto);
        return "redirect:/listarproducto?elimino";
    }

    @GetMapping("/habilitarproducto")
    public String PaginaHabilitarProducto(Model modelo) {
        modelo.addAttribute("productos", disable.findAllDisable());
        return "habilitarproducto";
    }

    @GetMapping("/habilitaproducto/{id}")
    public String HabilitaProducto(@PathVariable Long id, Model modelo) {
        ProductoEntity objproducto = servicio.findById(id);
        servicio.enable(objproducto);
        return "redirect:/listarproducto?habilito";
    }
    
}