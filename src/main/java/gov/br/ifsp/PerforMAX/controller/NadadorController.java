package gov.br.ifsp.PerforMAX.controller;

import gov.br.ifsp.PerforMAX.dto.NadadorDto;
import gov.br.ifsp.PerforMAX.model.Nadador;
import gov.br.ifsp.PerforMAX.service.NadadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nadador")
public class NadadorController {

    private final NadadorService nadadorService;

    @Autowired
    public NadadorController(NadadorService nadadorService) {
        this.nadadorService = nadadorService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarNadador(@RequestBody NadadorDto nadadorDto) {

        if(nadadorService.cpfExistente(nadadorDto.getCpf())) {
            return new ResponseEntity<>("CPF já cadastrado", HttpStatus.CONFLICT) ;
        }

        Nadador nadador = nadadorService.cadastrar(nadadorDto);

        return ResponseEntity.ok(new NadadorDto(nadador));

    }

    @PatchMapping("/{cpf}")
    @Transactional
    public ResponseEntity<?> alterarNadador(@PathVariable Long cpf, @RequestBody NadadorDto nadadorDto) {

        Nadador nadador = nadadorService.buscarCpf(cpf);

        if(nadador == null) {
            return new ResponseEntity<>("Nadador não encontrado", HttpStatus.NOT_FOUND) ;
        }

        nadador.atualiza(nadadorDto);

        nadadorService.salvar(nadador);

        return ResponseEntity.ok(new NadadorDto(nadador));

    }

    @GetMapping
    public ResponseEntity<?> listarNadador() {

        List<Nadador> nadadores = nadadorService.listar();

        return  ResponseEntity.ok(nadadores.stream().map(NadadorDto::new));

    }

    @DeleteMapping("/{cpf}")
    @Transactional
    public ResponseEntity<?> deletarNadador(@PathVariable Long cpf) {

        Nadador nadador = nadadorService.buscarCpf(cpf);

        if(nadador == null) {
            return new ResponseEntity<>("Nadador não encontrado", HttpStatus.NOT_FOUND) ;
        }

        nadadorService.deletar(nadador);

        return ResponseEntity.ok(new NadadorDto(nadador));

    }


}
