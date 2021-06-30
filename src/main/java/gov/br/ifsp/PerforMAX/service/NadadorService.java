package gov.br.ifsp.PerforMAX.service;

import gov.br.ifsp.PerforMAX.dto.NadadorDto;
import gov.br.ifsp.PerforMAX.model.Nadador;
import gov.br.ifsp.PerforMAX.repository.NadadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NadadorService {

    private final NadadorRepository nadadorRepository;

    @Autowired
    public NadadorService(NadadorRepository nadadorRepository) {
        this.nadadorRepository = nadadorRepository;
    }


    public boolean cpfExistente(Long cpf) {

        Nadador nadador = nadadorRepository.findByCpf(cpf);

        return nadador != null;
    }

    public Nadador cadastrar(NadadorDto nadadorDto) {

        Nadador nadador = new Nadador(nadadorDto);

        nadadorRepository.save(nadador);

        return nadador;

    }

    public Nadador buscarCpf(Long cpf) {

        return nadadorRepository.findByCpf(cpf);

    }

    public void salvar(Nadador nadador) {

        nadadorRepository.save(nadador);
    }

    public List<Nadador> listar() {

        List<Nadador> nadadores = nadadorRepository.findAll();

        return nadadores;

    }

    public void deletar(Nadador nadador) {

        nadadorRepository.delete(nadador);

    }
}
