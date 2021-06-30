package gov.br.ifsp.PerforMAX.controller;

import gov.br.ifsp.PerforMAX.dto.LoginDto;
import gov.br.ifsp.PerforMAX.dto.UsuarioDto;
import gov.br.ifsp.PerforMAX.model.Usuario;
import gov.br.ifsp.PerforMAX.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller("/login")
public class LoginController {

    private final UsuarioService usuarioService;

    @Autowired
    public LoginController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@ModelAttribute LoginDto loginDto) {

        Usuario usuario = usuarioService.login(loginDto);

        if(usuario == null) {
            return new ResponseEntity<>("Usuário não encontrado",HttpStatus.NOT_FOUND) ;
        }

        return ResponseEntity.ok(new LoginDto(usuario));
    }

    @PostMapping("/signup")
    @Transactional
    public ResponseEntity<UsuarioDto> cadastrar(@ModelAttribute UsuarioDto usuarioDto) {

        Usuario usuario = usuarioService.cadastrar(usuarioDto);

        return ResponseEntity.ok(new UsuarioDto(usuario));
    }


}
