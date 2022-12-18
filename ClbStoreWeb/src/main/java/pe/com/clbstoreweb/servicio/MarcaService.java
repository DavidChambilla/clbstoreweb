package pe.com.clbstoreweb.servicio;

import java.util.List;
import java.util.Optional;
import pe.com.clbstoreweb.modelo.MarcaEntity;

public interface MarcaService {

    //funcion para mostrar todos los datos
    List<MarcaEntity> findAll();

    //funcion para buscar por codigo
    MarcaEntity findById(Long id);

    //funcion para registrar
    MarcaEntity add(MarcaEntity c);

    //funcion para actualizar
    MarcaEntity update(MarcaEntity c);

    //funcion para eliminar
    MarcaEntity delete(MarcaEntity c);

    //funcion para mostrar datos habilitados
    List<MarcaEntity> findAllCustom();
    
        //funcion para mostrar datos deshabilitados
    List<MarcaEntity> findAllDisable();
    

    MarcaEntity enable(MarcaEntity c);
}
