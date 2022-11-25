package giocattolandia.repository;

import giocattolandia.model.Toys;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface ToysRepository extends JpaRepository<Toys,Long> {

    @Query(value = "SELECT * From Toys WHERE product_name LIKE %:name%", nativeQuery = true)
    List<Toys> findByPieceOfName(String name);

    Toys findByBarCode(Long barCode);

    @Query(value = "SELECT * From Toys WHERE product_name LIKE %:name% AND immediate_avaiability = :avaibility", nativeQuery = true)
    List<Toys> findToysByNameAndAvaiability(String name, boolean avaibility);
}
