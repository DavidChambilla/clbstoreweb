package pe.com.clbstoreweb.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clbstoreweb.modelo.ProductoEntity;
import pe.com.clbstoreweb.modelo.CategoriaEntity;
import pe.com.clbstoreweb.repositorio.CategoriaRepository;
import pe.com.clbstoreweb.repositorio.ProductoDisable;
import pe.com.clbstoreweb.repositorio.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productorepositorio;
    @Autowired
    private CategoriaRepository categoriarepositorio;
    
    @Autowired
    private ProductoDisable productodisable;
    

    @Override
    public List<ProductoEntity> findAll() {
        return productorepositorio.findAll();
    }

    @Override
    public ProductoEntity findById(Long id) {
        return productorepositorio.findById(id).get();
    }

    @Override
    public ProductoEntity add(ProductoEntity c) {
        return productorepositorio.save(c);
    }

    @Override
    public ProductoEntity update(ProductoEntity c) {
        ProductoEntity objproducto = productorepositorio.getById(c.getCodigo());
        BeanUtils.copyProperties(c, objproducto);
        return productorepositorio.save(objproducto);
    }

    @Override
    public ProductoEntity delete(ProductoEntity c) {
        ProductoEntity objproducto = productorepositorio.getById(c.getCodigo());
        objproducto.setEstado(false);
        return productorepositorio.save(objproducto);
    }

    @Override
    public List<ProductoEntity> findAllCustom() {
        return productorepositorio.findAllCustom();
    }

    @Override
    public List<ProductoEntity> findAllDisable() {
        return productodisable.findAllDisable();
    }

    @Override
    public ProductoEntity enable(ProductoEntity c) {
        ProductoEntity objproducto = productorepositorio.getById(c.getCodigo());
        objproducto.setEstado(true);
        return productorepositorio.save(objproducto);
    }

}
