package gov.br.ifsp.PerforMAX.repository;

import gov.br.ifsp.PerforMAX.model.Nadador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NadadorRepository extends JpaRepository<Nadador, Long> {


    Nadador findByCpf(Long cpf);

}
