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
import pe.com.clbstoreweb.modelo.MarcaEntity;
import pe.com.clbstoreweb.repositorio.MarcaDisable;
import pe.com.clbstoreweb.servicio.MarcaService;

@RestController
@RequestMapping("/marca")
public class MarcaRestController {

    @Autowired
    private MarcaService marcaservice;
    
    @Autowired
    private MarcaDisable marcadisable;

    @GetMapping
    public List<MarcaEntity> findAll() {
        return marcaservice.findAll();
    }

    @GetMapping("/custom")
    public List<MarcaEntity> findAllCustom() {
        return marcaservice.findAllCustom();
    }
    
    @GetMapping("/disable")
    public List<MarcaEntity> findAllDisable() {
        return marcadisable.findAllDisable();
    }

    @GetMapping("/{id}")
    public MarcaEntity findById(@PathVariable Long id) {
        return marcaservice.findById(id);
    }

    @PostMapping
    public MarcaEntity add(@RequestBody MarcaEntity c) {
        return marcaservice.add(c);
    }

    @PutMapping("/{id}")
    public MarcaEntity update(@PathVariable Long id, @RequestBody MarcaEntity c) {
        c.setCodigo(id);
        return marcaservice.update(c);
    }

    @DeleteMapping("/{id}")
    public MarcaEntity delete(@PathVariable Long id) {
        MarcaEntity objmarca = new MarcaEntity();
        objmarca.setEstado(false);
        return marcaservice.delete(MarcaEntity.builder().codigo(id).build());
    }

    @PostMapping("/habilitar/{id}")
    public MarcaEntity enable(@PathVariable Long id) {
        MarcaEntity objmarca = new MarcaEntity();
        objmarca.setEstado(true);
        return marcaservice.enable(MarcaEntity.builder().codigo(id).build());
    }

}
