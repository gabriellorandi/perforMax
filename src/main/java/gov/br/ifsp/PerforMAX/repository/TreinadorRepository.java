package gov.br.ifsp.PerforMAX.repository;

import gov.br.ifsp.PerforMAX.model.Treinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinadorRepository extends JpaRepository<Treinador, Long> {

     Treinador findByCpf(Long cpf);

}
