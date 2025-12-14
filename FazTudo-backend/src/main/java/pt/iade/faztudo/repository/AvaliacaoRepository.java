package pt.iade.faztudo.repository;

import pt.iade.faztudo.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {

    List<Avaliacao> findByUserIdUserOrderByDataAvaliacaoDesc(Integer idUser);

    List<Avaliacao> findByVendedorCategoriaIdVendedorCategoriaOrderByDataAvaliacaoDesc(
            Integer idVendedorCategoria);

    @Query("SELECT a FROM Avaliacao a " +
           "JOIN a.vendedorCategoria vc " +
           "WHERE vc.vendedor.idVendedor = :idVendedor " +
           "ORDER BY a.dataAvaliacao DESC")
    List<Avaliacao> findByVendedorId(@Param("idVendedor") Integer idVendedor);

    boolean existsByUserIdUserAndVendedorCategoriaIdVendedorCategoria(
            Integer idUser, Integer idVendedorCategoria);

    @Query("SELECT AVG(a.nota) FROM Avaliacao a " +
           "JOIN a.vendedorCategoria vc " +
           "WHERE vc.vendedor.idVendedor = :idVendedor")
    Double getMediaAvaliacoesByVendedor(@Param("idVendedor") Integer idVendedor);

    @Query("SELECT COUNT(a) FROM Avaliacao a " +
           "JOIN a.vendedorCategoria vc " +
           "WHERE vc.vendedor.idVendedor = :idVendedor")
    Long countByVendedorId(@Param("idVendedor") Integer idVendedor);

    @Query("SELECT a FROM Avaliacao a " +
           "JOIN FETCH a.user " +
           "JOIN FETCH a.vendedorCategoria vc " +
           "JOIN FETCH vc.vendedor " +
           "JOIN FETCH vc.categoria " +
           "WHERE a.idAvaliacao = :id")
    Optional<Avaliacao> findByIdWithDetails(@Param("id") Integer id);
}