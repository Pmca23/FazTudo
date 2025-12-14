package pt.iade.faztudo.repository;

import pt.iade.faztudo.model.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer> {

    List<Localizacao> findByCidadeContainingIgnoreCase(String cidade);

    List<Localizacao> findByCodigoPostal(String codigoPostal);
}