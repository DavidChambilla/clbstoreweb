
package pe.com.clbstoreweb.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.clbstoreweb.modelo.ProductoEntity;
import pe.com.clbstoreweb.servicio.ProductoService;


@Controller
public class ProductoControlador {
    @Autowired
    private ProductoService servicio;
    @Autowired
    private ProductoService serviciocurso;

    

    @GetMapping("/listarproducto")
    public String PaginaListarCarrera(Model modelo) {
        modelo.addAttribute("productos", servicio.findAll());
        return "listarproducto";
    }
    @GetMapping("/registroproducto")
    public String MostrarFormularioRegistro(Model modelo) {
        //es el nombre que tendra la pagina web
        modelo.addAttribute("productos", serviciocurso.findAll());
        return "registroproducto";
    }

    @ModelAttribute("producto")
    public ProductoEntity RegistroProducto() {
        return new ProductoEntity();
    }

    @PostMapping("/registroproducto")
    public String RegistroProductoNuevo(
            @ModelAttribute("producto") ProductoEntity c) {
        servicio.add(c);
        return "redirect:/listarproducto?correcto";
    }
    
}
