package gov.br.ifsp.PerforMAX.controller;

import gov.br.ifsp.PerforMAX.dto.TreinoDto;
import gov.br.ifsp.PerforMAX.model.*;
import gov.br.ifsp.PerforMAX.service.NadadorService;
import gov.br.ifsp.PerforMAX.service.TreinadorService;
import gov.br.ifsp.PerforMAX.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/treino")
public class TreinoController {

    private final TreinoService treinoService;
    private final TreinadorService treinadorService;
    private final NadadorService nadadorService;

    @Autowired
    public TreinoController(TreinoService treinoService, TreinadorService treinadorService, NadadorService nadadorService) {
        this.treinoService = treinoService;
        this.treinadorService = treinadorService;
        this.nadadorService = nadadorService;
    }


    @PostMapping("/{id}/treinador/{cpf}")
    @Transactional
    public ResponseEntity<?> cadastrarTreinador(@PathVariable Long id, @PathVariable Long cpf) {


        Treinador treinador = treinadorService.buscarCpf(cpf);

        if(treinador == null) {
            return new ResponseEntity<>("Treinador não encontrado", HttpStatus.NOT_FOUND) ;
        }

        Treino treino = treinoService.buscar(id);

        if(treino == null) {
            return new ResponseEntity<>("Treino não encontrado", HttpStatus.NOT_FOUND) ;
        }

        treino.setTreinador(treinador);

        treinoService.salvarTreino(treino);

        return ResponseEntity.ok(new TreinoDto(treino));

    }

    @PostMapping("/{id}/nadador/{cpf}")
    @Transactional
    public ResponseEntity<?> cadastrarNadador(@PathVariable Long id, @PathVariable Long cpf) {


        Nadador nadador = nadadorService.buscarCpf(cpf);

        if(nadador == null) {
            return new ResponseEntity<>("Nadador não encontrado", HttpStatus.NOT_FOUND) ;
        }

        Treino treino = treinoService.buscar(id);

        if(treino == null) {
            return new ResponseEntity<>("Treino não encontrado", HttpStatus.NOT_FOUND) ;
        }

        treino.getNadadores().add(nadador);

        treinoService.salvarTreino(treino);

        return ResponseEntity.ok(new TreinoDto(treino));

    }

    @DeleteMapping("/{id}/nadador/{cpf}")
    @Transactional
    public ResponseEntity<?> deletarNadador(@PathVariable Long id, @PathVariable Long cpf) {


        Nadador nadador = nadadorService.buscarCpf(cpf);

        if(nadador == null) {
            return new ResponseEntity<>("Nadador não encontrado", HttpStatus.NOT_FOUND) ;
        }

        Treino treino = treinoService.buscar(id);

        if(treino == null) {
            return new ResponseEntity<>("Treino não encontrado", HttpStatus.NOT_FOUND) ;
        }

        treino.getNadadores().remove(nadador);

        treinoService.salvarTreino(treino);

        return ResponseEntity.ok(new TreinoDto(treino));

    }

    @PostMapping("/fisico")
    @Transactional
    public ResponseEntity<?> cadastrarTreinoFisico(@RequestBody TreinoDto treinoDto) {


        TreinoFisico treinoFisico = treinoService.cadastrarTreinoFisico(treinoDto);

        return ResponseEntity.ok(new TreinoDto(treinoFisico));

    }

    @PostMapping("/tempo")
    @Transactional
    public ResponseEntity<?> cadastrarTreinoTempo(@RequestBody TreinoDto treinoDto) {


        TreinoTempo treinoTempo = treinoService.cadastrarTreinoTempo(treinoDto);

        return ResponseEntity.ok(new TreinoDto(treinoTempo));

    }

    @PatchMapping("/{id}")
    @Transactional
    public ResponseEntity<?> alterarTreino(@PathVariable Long id, @RequestBody TreinoDto treinoDto) {

        Treino treino = treinoService.buscar(id);

        if(treino == null) {
            return new ResponseEntity<>("Treino não encontrado", HttpStatus.NOT_FOUND) ;
        }

        if (treino.isFisico()) {
            treino.atualizaFisico(treinoDto);
        } else {
            treino.atualizaTempo(treinoDto);
        }

        treinoService.salvarTreino(treino);

        return ResponseEntity.ok(new TreinoDto(treino));

    }

    @GetMapping
    public ResponseEntity<?> listarTreinos() {

        List<Treino> treinos = treinoService.listar();

        return  ResponseEntity.ok(treinos.stream().map(TreinoDto::new));

    }

    @DeleteMapping("/{cpf}")
    @Transactional
    public ResponseEntity<?> deletarTreino(@PathVariable Long id) {

        Treino treino = treinoService.buscar(id);

        if(treino == null) {
            return new ResponseEntity<>("Treino não encontrado", HttpStatus.NOT_FOUND) ;
        }

        treinoService.deletar(treino);

        return ResponseEntity.ok(new TreinoDto(treino));

    }

}
