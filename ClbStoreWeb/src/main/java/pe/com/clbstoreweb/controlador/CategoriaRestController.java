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
import pe.com.clbstoreweb.modelo.CategoriaEntity;
import pe.com.clbstoreweb.servicio.CategoriaService;


@RestController
@RequestMapping("/categoria")
public class CategoriaRestController {
    @Autowired
    private CategoriaService categoriaservice;


    //@GetMapping sirve para obtener valores
    @GetMapping
    public List<CategoriaEntity> findAll() {
        return categoriaservice.findAll();
    }

    @GetMapping("/custom")
    public List<CategoriaEntity> findAllCustom() {
        return categoriaservice.findAllCustom();
    }

    @GetMapping("/{id}")
    public CategoriaEntity findById(@PathVariable Long id) {
        return categoriaservice.findById(id);
    }

    //@PostMapping permite enviar(registrar) valores
    @PostMapping
    public CategoriaEntity add(@RequestBody CategoriaEntity c) {
        return categoriaservice.add(c);
    }

    //@PutMapping permite actualizar
    @PutMapping("/{id}")
    public CategoriaEntity update(@PathVariable Long id, @RequestBody CategoriaEntity c) {
        c.setCodigo(id);
        return categoriaservice.update(c);
    }

    //@DeleteMapping permite eliminar un valor
    @DeleteMapping("/{id}")
    public CategoriaEntity delete(@PathVariable Long id) {
        //c.setCodigo(id);
        //return carreraservice.delete(c);
        CategoriaEntity objcategoria = new CategoriaEntity();
        objcategoria.setEstado(false);
        return categoriaservice.delete(CategoriaEntity.builder().codigo(id).build());
    }
}
