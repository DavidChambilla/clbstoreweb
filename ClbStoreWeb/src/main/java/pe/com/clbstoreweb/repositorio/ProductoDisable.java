package pe.com.clbstoreweb.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.clbstoreweb.modelo.ProductoEntity;



public interface ProductoDisable extends JpaRepository<ProductoEntity, Long> {
    //creamos una funcion para mostrar todos los datos habilitados
    //select * from Categoria where estcur=1 --> MySQL
    //select variable from Entidad variable -->JPQL
    //select c from CategoriaEntity c where c.estado=1
    @Query("select c from ProductoEntity c where c.estado=0")
    List<ProductoEntity> findAllDisable();
}