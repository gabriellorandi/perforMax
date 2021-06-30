package gov.br.ifsp.PerforMAX.dto;


import gov.br.ifsp.PerforMAX.model.Nadador;

public class NadadorDto {

    private Long cpf;
    private String nome;
    private Integer idade;
    private String especialidade;

    public NadadorDto(){}

    public NadadorDto(Nadador nadador) {
        this.cpf = nadador.getCpf();
        this.nome = nadador.getNome();
        this.idade = nadador.getIdade();
        this.especialidade = nadador.getEspecialidade();

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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
