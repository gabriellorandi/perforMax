package gov.br.ifsp.PerforMAX.repository;

import gov.br.ifsp.PerforMAX.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long> {


    @Query(value = "SELECT t FROM Treinos t WHERE t.nome LIKE :nome AND t.data BETWEEN :dataInicial AND :dataFinal ")
    List<Treino> findAllByNadadorNomeAndData(String nome, ZonedDateTime dataInicial, ZonedDateTime dataFinal);
}
