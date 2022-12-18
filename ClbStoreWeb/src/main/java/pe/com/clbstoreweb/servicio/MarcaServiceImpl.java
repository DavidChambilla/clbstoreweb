package pe.com.clbstoreweb.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.clbstoreweb.modelo.MarcaEntity;
import pe.com.clbstoreweb.repositorio.MarcaDisable;
import pe.com.clbstoreweb.repositorio.MarcaRepository;


@Service
public class MarcaServiceImpl implements MarcaService {


    @Autowired
    private MarcaRepository marcarepositorio;
    
    @Autowired
    private MarcaDisable marcadisable;

    @Override
    public List<MarcaEntity> findAll() {
        return marcarepositorio.findAll();
    }

    @Override
    public MarcaEntity findById(Long id) {
        return marcarepositorio.findById(id).get();
    }

    @Override
    public MarcaEntity add(MarcaEntity c) {
        return marcarepositorio.save(c);
    }

    @Override
    public MarcaEntity update(MarcaEntity c) {
        MarcaEntity objmarca = marcarepositorio.getById(c.getCodigo());
        
        BeanUtils.copyProperties(c, objmarca);
        return marcarepositorio.save(objmarca);
    }

    @Override
    public MarcaEntity delete(MarcaEntity c) {
        MarcaEntity objmarca = marcarepositorio.getById(c.getCodigo());
        objmarca.setEstado(false);
        return marcarepositorio.save(objmarca);
    }

    @Override
    public List<MarcaEntity> findAllCustom() {
        return marcarepositorio.findAllCustom();
    }
    
    @Override
    public List<MarcaEntity> findAllDisable() {
        return marcadisable.findAllDisable();
    }
    
    @Override
    public MarcaEntity enable(MarcaEntity c) {
        MarcaEntity objmarca = marcarepositorio.getById(c.getCodigo());
        objmarca.setEstado(true);
        return marcarepositorio.save(objmarca);
    }

}
