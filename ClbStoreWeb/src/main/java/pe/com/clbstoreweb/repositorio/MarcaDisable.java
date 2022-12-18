package pe.com.clbstoreweb.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.clbstoreweb.modelo.MarcaEntity;



public interface MarcaDisable extends JpaRepository<MarcaEntity, Long> {
    //creamos una funcion para mostrar todos los datos habilitados
    //select * from Marca where estcur=1 --> MySQL
    //select variable from Entidad variable -->JPQL
    //select c from MarcaEntity c where c.estado=1
    @Query("select c from MarcaEntity c where c.estado=0")
    List<MarcaEntity> findAllDisable();
}