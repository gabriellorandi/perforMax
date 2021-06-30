package gov.br.ifsp.PerforMAX.dto;

import gov.br.ifsp.PerforMAX.model.Usuario;

public class UsuarioDto {

    private Long cpf;
    private String nome;
    private Integer idade;
    private String login;
    private String senha;

    public UsuarioDto(Usuario usuario) {
        this.cpf = usuario.getCpf();
        this.nome = usuario.getNome();
        this.idade = usuario.getIdade();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
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
