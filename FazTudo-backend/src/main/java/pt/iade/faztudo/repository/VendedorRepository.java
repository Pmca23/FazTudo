package pt.iade.faztudo.repository;

import pt.iade.faztudo.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

    Optional<Vendedor> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<Vendedor> findByUserIdUser(Integer idUser);

    @Query("SELECT DISTINCT v FROM Vendedor v " +
           "JOIN v.categorias vc " +
           "WHERE vc.categoria.idCategoria = :idCategoria")
    List<Vendedor> findByCategoriaId(@Param("idCategoria") Integer idCategoria);

    @Query("SELECT DISTINCT v FROM Vendedor v " +
           "JOIN FETCH v.localizacao l " +
           "JOIN v.categorias vc " +
           "WHERE vc.categoria.idCategoria = :idCategoria " +
           "AND l.latitude IS NOT NULL AND l.longitude IS NOT NULL")
    List<Vendedor> findByCategoriaIdWithLocalizacao(@Param("idCategoria") Integer idCategoria);

    @Query("SELECT v FROM Vendedor v " +
           "LEFT JOIN FETCH v.categorias vc " +
           "LEFT JOIN FETCH vc.categoria " +
           "WHERE v.idVendedor = :id")
    Optional<Vendedor> findByIdWithCategorias(@Param("id") Integer id);

    @Query("SELECT DISTINCT v FROM Vendedor v " +
           "LEFT JOIN FETCH v.categorias vc " +
           "LEFT JOIN FETCH vc.categoria")
    List<Vendedor> findAllWithCategorias();
}