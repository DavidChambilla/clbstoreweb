package pe.com.clbstoreweb.servicio;

import java.util.List;
import java.util.Optional;
import pe.com.clbstoreweb.modelo.ProductoEntity;


public interface ProductoService {

    //funcion para mostrar todos los datos
    List<ProductoEntity> findAll();

    //funcion para buscar por codigo
    ProductoEntity findById(Long id);

    //funcion para registrar
    ProductoEntity add(ProductoEntity c);

    //funcion para actualizar
    ProductoEntity update(ProductoEntity c);

    //funcion para eliminar
    ProductoEntity delete(ProductoEntity c);

    //funcion para mostrar datos habilitados
    List<ProductoEntity> findAllCustom();
    
    List<ProductoEntity> findAllDisable();
    
    ProductoEntity enable(ProductoEntity c);
}