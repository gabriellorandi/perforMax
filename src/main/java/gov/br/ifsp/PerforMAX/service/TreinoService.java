package gov.br.ifsp.PerforMAX.service;

import gov.br.ifsp.PerforMAX.dto.TreinoDto;
import gov.br.ifsp.PerforMAX.model.Treinador;
import gov.br.ifsp.PerforMAX.model.Treino;
import gov.br.ifsp.PerforMAX.model.TreinoFisico;
import gov.br.ifsp.PerforMAX.model.TreinoTempo;
import gov.br.ifsp.PerforMAX.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class TreinoService {

    private final TreinoRepository treinoRepository;

    @Autowired
    public TreinoService(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }

    public TreinoFisico cadastrarTreinoFisico(TreinoDto treinoDto) {

        TreinoFisico treinoFisico = new TreinoFisico(treinoDto);

        treinoRepository.save(treinoFisico);

        return treinoFisico;

    }

    public TreinoTempo cadastrarTreinoTempo(TreinoDto treinoDto) {

        TreinoTempo treinoTempo = new TreinoTempo(treinoDto);

        treinoRepository.save(treinoTempo);

        return treinoTempo;
    }

    public Treino buscar(Long id) {
        return treinoRepository.getById(id);
    }

    public void salvarTreino(Treino treino) {
        treinoRepository.save(treino);
    }

    public List<Treino> listar() {

        List<Treino> treinos = treinoRepository.findAll();

        return treinos;
    }

    public void deletar(Treino treino) {

        treinoRepository.delete(treino);

    }

    public List<Treino> buscarTreinosPorNomeEData(String nome, ZonedDateTime dataInicial, ZonedDateTime dataFinal) {


        return treinoRepository.findAllByNadadorNomeAndData(nome,dataInicial,dataFinal);

    }
}
