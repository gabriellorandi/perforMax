package gov.br.ifsp.PerforMAX.model;

import gov.br.ifsp.PerforMAX.dto.UsuarioDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "usuario")
public class Usuario {

    @Id
    private Long cpf;
    private String nome;
    private Integer idade;
    private String login;
    private String senha;

    public Usuario(){}

    public Usuario(UsuarioDto usuarioDto) {
        this.cpf = usuarioDto.getCpf();
        this.nome = usuarioDto.getNome();
        this.idade = usuarioDto.getIdade();
        this.login = usuarioDto.getLogin();
        this.senha = usuarioDto.getSenha();
    }

    public static boolean isAdmin(Object o) {
        return o instanceof Administrador;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
