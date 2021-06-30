package gov.br.ifsp.PerforMAX.dto;


import gov.br.ifsp.PerforMAX.model.Treinador;

public class TreinadorDto {

    private Long cpf;
    private String nome;
    private Integer idade;

    public TreinadorDto(Treinador treinador) {
        this.cpf = treinador.getCpf();
        this.nome = treinador.getNome();
        this.idade = treinador.getIdade();
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
}
