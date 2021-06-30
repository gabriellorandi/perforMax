package gov.br.ifsp.PerforMAX.dto;

import gov.br.ifsp.PerforMAX.model.Usuario;

public class LoginDto {

    private String login;
    private String senha;

    public LoginDto() {

    }

    public LoginDto(Usuario usuario) {
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
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
