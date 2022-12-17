package pe.com.clbstoreweb.servicio;

import java.util.List;
import java.util.Optional;
import pe.com.clbstoreweb.modelo.CategoriaEntity;

public interface CategoriaService {

    //funcion para mostrar todos los datos
    List<CategoriaEntity> findAll();

    //funcion para buscar por codigo
    CategoriaEntity findById(Long id);

    //funcion para registrar
    CategoriaEntity add(CategoriaEntity c);

    //funcion para actualizar
    CategoriaEntity update(CategoriaEntity c);

    //funcion para eliminar
    CategoriaEntity delete(CategoriaEntity c);

    //funcion para mostrar datos habilitados
    List<CategoriaEntity> findAllCustom();
    
        //funcion para mostrar datos deshabilitados
    List<CategoriaEntity> findAllDisable();
    

    CategoriaEntity enable(CategoriaEntity c);
}
