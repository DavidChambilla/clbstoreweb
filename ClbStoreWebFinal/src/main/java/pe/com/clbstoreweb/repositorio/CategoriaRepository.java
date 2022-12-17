package pe.com.clbstoreweb.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.clbstoreweb.modelo.CategoriaEntity;



public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
    //creamos una funcion para mostrar todos los datos habilitados
    //select * from Categoria where estcur=1 --> MySQL
    //select variable from Entidad variable -->JPQL
    //select c from CategoriaEntity c where c.estado=1
    @Query("select c from CategoriaEntity c where c.estado=1")
    List<CategoriaEntity> findAllCustom();
}