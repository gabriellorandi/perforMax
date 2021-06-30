package gov.br.ifsp.PerforMAX.controller;

import gov.br.ifsp.PerforMAX.dto.RelatorioDto;
import gov.br.ifsp.PerforMAX.model.Usuario;
import gov.br.ifsp.PerforMAX.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.ZonedDateTime;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {

    private final RelatorioService relatorioService;

    @Autowired
    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping
    public ResponseEntity<?> relatorioComparativos(HttpSession session, String nome, ZonedDateTime dataInicial, ZonedDateTime dataFinal) {

        Object usuario = session.getAttribute("usuario");
        if(!Usuario.isAdmin(usuario)) {
            return new ResponseEntity<>("Acesso negado", HttpStatus.FORBIDDEN) ;
        }

        RelatorioDto relatorioDto = relatorioService.relatorioComparativo(nome, dataInicial, dataFinal);

        return  ResponseEntity.ok(relatorioDto);

    }

}
