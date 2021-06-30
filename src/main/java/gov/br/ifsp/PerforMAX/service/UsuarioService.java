package gov.br.ifsp.PerforMAX.service;

import gov.br.ifsp.PerforMAX.dto.LoginDto;
import gov.br.ifsp.PerforMAX.dto.UsuarioDto;
import gov.br.ifsp.PerforMAX.model.Usuario;
import gov.br.ifsp.PerforMAX.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrar(UsuarioDto usuarioDto) {

        Usuario usuario = new Usuario(usuarioDto);

        usuarioRepository.save(usuario);

        return usuario;

    }

    public Usuario login(LoginDto loginDto) {

        Usuario usuario = usuarioRepository.findByLoginAndSenha(loginDto.getLogin(), loginDto.getSenha());

        return usuario;

    }
}
