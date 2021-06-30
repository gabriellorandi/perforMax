package gov.br.ifsp.PerforMAX.service;

import gov.br.ifsp.PerforMAX.dto.RelatorioDto;
import gov.br.ifsp.PerforMAX.dto.TreinoDto;
import gov.br.ifsp.PerforMAX.model.Treino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelatorioService {

    private final TreinoService treinoService;

    @Autowired
    public RelatorioService(TreinoService treinoService) {
        this.treinoService = treinoService;
    }


    public RelatorioDto relatorioComparativo(String nome, ZonedDateTime dataInicial, ZonedDateTime dataFinal) {

        List<Treino> treinos = treinoService.buscarTreinosPorNomeEData(nome,dataInicial,dataFinal);

        RelatorioDto relatorioDto = new RelatorioDto();

        relatorioDto.setNome(nome);
        relatorioDto.setTreinos( treinos.stream().map(TreinoDto::new).collect(Collectors.toList()) );

        return relatorioDto;

    }
}
