package pe.com.clbstoreweb.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clbstoreweb.modelo.CategoriaEntity;
import pe.com.clbstoreweb.repositorio.CategoriaRepository;


@Service
public class CategoriaServiceImpl implements CategoriaService{
    //@Autowired  permite inyectar la dependencia
    @Autowired
    private CategoriaRepository categoriarepositorio;
    @Override
    public List<CategoriaEntity> findAll() {
        return categoriarepositorio.findAll();
    }
    @Override
    public CategoriaEntity findById(Long id) {
        return categoriarepositorio.findById(id).get();
    }
    @Override
    public CategoriaEntity add(CategoriaEntity c) {
        return categoriarepositorio.save(c);
    }
    @Override
    public CategoriaEntity update(CategoriaEntity c) {
        CategoriaEntity objcategoria=categoriarepositorio.getById(c.getCodigo());
        //BeansUtils permite obtener funciones de Spring
        BeanUtils.copyProperties(c, objcategoria);
        return categoriarepositorio.save(objcategoria);
    }

    @Override
    public CategoriaEntity delete(CategoriaEntity c) {
       CategoriaEntity objcategoria=categoriarepositorio.getById(c.getCodigo());
       objcategoria.setEstado(false);
       return categoriarepositorio.save(objcategoria);
    }


    @Override
    public List<CategoriaEntity> findAllCustom() {
        return categoriarepositorio.findAllCustom();
    }
}
