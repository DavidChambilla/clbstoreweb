package pe.com.clbstoreweb.repositorio;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.clbstoreweb.modelo.ProductoEntity;


public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
    @Query("select c from ProductoEntity c where c.estado=1")
    List<ProductoEntity> findAllCustom();
}