package gov.br.ifsp.PerforMAX.controller;

import gov.br.ifsp.PerforMAX.dto.TreinadorDto;
import gov.br.ifsp.PerforMAX.model.Treinador;
import gov.br.ifsp.PerforMAX.service.TreinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/treinador")
public class TreinadorController {

    private final TreinadorService treinadorService;

    @Autowired
    public TreinadorController(TreinadorService treinadorService) {
        this.treinadorService = treinadorService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarTreinador(@ModelAttribute TreinadorDto treinadorDto) {

        if(treinadorService.cpfExistente(treinadorDto.getCpf())) {
            return new ResponseEntity<>("CPF já cadastrado", HttpStatus.CONFLICT) ;
        }

        Treinador treinador = treinadorService.cadastrar(treinadorDto);

        return ResponseEntity.ok(new TreinadorDto(treinador));

    }

    @PatchMapping("/{cpf}")
    @Transactional
    public ResponseEntity<?> alterarTreinador(@PathVariable Long cpf, @ModelAttribute TreinadorDto treinadorDto) {

        Treinador treinador = treinadorService.buscarCpf(cpf);

        if(treinador == null) {
            return new ResponseEntity<>("Treinador não encontrado", HttpStatus.NOT_FOUND) ;
        }

        treinador.atualiza(treinadorDto);

        treinadorService.salvar(treinador);

        return ResponseEntity.ok(new TreinadorDto(treinador));

    }

    @GetMapping
    public ResponseEntity<?> listarTreinador() {

        List<Treinador> treinadores = treinadorService.listar();

        return  ResponseEntity.ok(treinadores.stream().map(TreinadorDto::new));

    }

    @DeleteMapping("/{cpf}")
    @Transactional
    public ResponseEntity<?> deletarTreinador(@PathVariable Long cpf) {

        Treinador treinador = treinadorService.buscarCpf(cpf);

        if(treinador == null) {
            return new ResponseEntity<>("Treinador não encontrado", HttpStatus.NOT_FOUND) ;
        }

        treinadorService.deletar(treinador);

        return ResponseEntity.ok(new TreinadorDto(treinador));

    }


}
