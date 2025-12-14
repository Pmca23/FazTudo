package pt.iade.faztudo.repository;

import pt.iade.faztudo.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

    Optional<Estado> findByNome(String nome);

    boolean existsByNome(String nome);
}