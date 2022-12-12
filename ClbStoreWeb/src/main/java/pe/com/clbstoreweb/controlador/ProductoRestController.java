
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
import pe.com.clbstoreweb.servicio.ProductoService;


//@RestController define la clase como un controlador
@RestController
//@RequestMapping("/carrera") define el nombre del controlador
@RequestMapping("/producto")

public class ProductoRestController {
    @Autowired
    private ProductoService productoservice;

    //@GetMapping sirve para obtener valores
    @GetMapping
    public List<ProductoEntity> findAll() {
        return productoservice.findAll();
    }

    @GetMapping("/custom")
    public List<ProductoEntity> findAllCustom() {
        return productoservice.findAllCustom();
    }

    @GetMapping("/{id}")
    public Optional<ProductoEntity> findById(@PathVariable Long id) {
        return productoservice.findById(id);
    }

    //@PostMapping permite enviar(registrar) valores
    @PostMapping
    public ProductoEntity add(@RequestBody ProductoEntity c) { 
        return productoservice.add(c);
    }

    //@PutMapping permite actualizar
    @PutMapping("/{id}")
    public ProductoEntity update(@PathVariable Long id, @RequestBody ProductoEntity c) {
        c.setCodigo(id);
        return productoservice.update(c);
    }

    //@DeleteMapping permite eliminar un valor
    @DeleteMapping("/{id}")
    public ProductoEntity delete(@PathVariable Long id) {
        //c.setCodigo(id);
        //return carreraservice.delete(c);
        ProductoEntity objcategoria = new ProductoEntity();
        objcategoria.setEstado(false);
        return productoservice.delete(ProductoEntity.builder().codigo(id).build());
    }
}
