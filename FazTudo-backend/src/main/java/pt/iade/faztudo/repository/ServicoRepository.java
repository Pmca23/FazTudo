package pt.iade.faztudo.repository;

import pt.iade.faztudo.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    List<Servico> findByUserIdUserOrderByDataPublicacaoDesc(Integer idUser);

    @Query("SELECT s FROM Servico s " +
           "JOIN s.vendedorCategoria vc " +
           "WHERE vc.vendedor.idVendedor = :idVendedor " +
           "ORDER BY s.dataPublicacao DESC")
    List<Servico> findByVendedorId(@Param("idVendedor") Integer idVendedor);

    List<Servico> findByEstadoIdEstadoOrderByDataPublicacaoDesc(Integer idEstado);

    @Query("SELECT s FROM Servico s " +
           "JOIN FETCH s.vendedorCategoria vc " +
           "JOIN FETCH vc.vendedor " +
           "JOIN FETCH vc.categoria " +
           "JOIN FETCH s.user " +
           "JOIN FETCH s.estado " +
           "WHERE s.idServico = :id")
    Optional<Servico> findByIdWithDetails(@Param("id") Integer id);
}