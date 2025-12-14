package pt.iade.faztudo.repository;

import pt.iade.faztudo.model.VendedorCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendedorCategoriaRepository extends JpaRepository<VendedorCategoria, Integer> {

    List<VendedorCategoria> findByVendedorIdVendedor(Integer idVendedor);

    List<VendedorCategoria> findByCategoriaIdCategoria(Integer idCategoria);

    boolean existsByVendedorIdVendedorAndCategoriaIdCategoria(Integer idVendedor, Integer idCategoria);

    Optional<VendedorCategoria> findByVendedorIdVendedorAndCategoriaIdCategoria(
            Integer idVendedor, Integer idCategoria);

    @Query("SELECT AVG(a.nota) FROM Avaliacao a WHERE a.vendedorCategoria.idVendedorCategoria = :id")
    Double getMediaAvaliacoes(@Param("id") Integer id);

    @Query("SELECT COUNT(a) FROM Avaliacao a WHERE a.vendedorCategoria.idVendedorCategoria = :id")
    Long countAvaliacoes(@Param("id") Integer id);
}