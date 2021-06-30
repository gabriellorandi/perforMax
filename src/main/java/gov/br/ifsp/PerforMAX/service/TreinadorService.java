package gov.br.ifsp.PerforMAX.service;

import gov.br.ifsp.PerforMAX.dto.TreinadorDto;
import gov.br.ifsp.PerforMAX.model.Treinador;
import gov.br.ifsp.PerforMAX.repository.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinadorService {

    private final TreinadorRepository treinadorRepository;

    @Autowired
    public TreinadorService(TreinadorRepository treinadorRepository) {
        this.treinadorRepository = treinadorRepository;
    }

    public boolean cpfExistente(Long cpf) {

        Treinador treinador = treinadorRepository.findByCpf(cpf);

        return treinador != null;
    }

    public Treinador cadastrar(TreinadorDto treinadorDto) {

        Treinador treinador = new Treinador(treinadorDto);

        treinadorRepository.save(treinador);

        return treinador;

    }

    public Treinador buscarCpf(Long cpf) {

        return treinadorRepository.findByCpf(cpf);

    }

    public void salvar(Treinador treinador) {

        treinadorRepository.save(treinador);
    }

    public List<Treinador> listar() {

        List<Treinador> treinadores = treinadorRepository.findAll();

        return treinadores;

    }

    public void deletar(Treinador treinador) {

        treinadorRepository.delete(treinador);

    }
}
