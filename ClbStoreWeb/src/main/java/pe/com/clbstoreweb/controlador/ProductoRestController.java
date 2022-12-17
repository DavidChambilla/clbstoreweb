package pe.com.clbstoreweb.controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.clbstoreweb.modelo.ProductoEntity;
import pe.com.clbstoreweb.repositorio.ProductoDisable;
import pe.com.clbstoreweb.servicio.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoRestController {

    @Autowired
    private ProductoService productoservice;
    
    @Autowired
    private ProductoDisable productodisable;

    @GetMapping
    public List<ProductoEntity> findAll() {
        return productoservice.findAll();
    }

    @GetMapping("/custom")
    public List<ProductoEntity> findAllCustom() {
        return productoservice.findAllCustom();
    }
    
    @GetMapping("/disable")
    public List<ProductoEntity> findAllDisable() {
        return productodisable.findAllDisable();
    }

    @GetMapping("/{id}")
    public ProductoEntity findById(@PathVariable Long id) {
        return productoservice.findById(id);
    }

    @PostMapping
    public ProductoEntity add(@RequestBody ProductoEntity c) {
        return productoservice.add(c);
    }

    @PutMapping("/{id}")
    public ProductoEntity update(@PathVariable Long id, @RequestBody ProductoEntity c) {
        c.setCodigo(id);
        return productoservice.update(c);
    }

    @DeleteMapping("/{id}")
    public ProductoEntity delete(@PathVariable Long id) {
        ProductoEntity objproducto = new ProductoEntity();
        objproducto.setEstado(false);
        return productoservice.delete(ProductoEntity.builder().codigo(id).build());
    }
    
    @PostMapping("/habilitar/{id}")
    public ProductoEntity enable(@PathVariable Long id) {
        ProductoEntity objproducto = new ProductoEntity();
        objproducto.setEstado(true);
        return productoservice.enable(ProductoEntity.builder().codigo(id).build());
    }

}
