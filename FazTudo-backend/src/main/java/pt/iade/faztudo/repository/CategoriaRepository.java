package pt.iade.faztudo.repository;

import pt.iade.faztudo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findByNome(String nome);

    List<Categoria> findByNomeContainingIgnoreCase(String termo);

    List<Categoria> findAllByOrderByNomeAsc();
}