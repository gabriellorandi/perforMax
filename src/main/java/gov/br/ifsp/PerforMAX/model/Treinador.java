package gov.br.ifsp.PerforMAX.model;

import gov.br.ifsp.PerforMAX.dto.TreinadorDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "treinador")
public class Treinador {

    @Id
    private Long cpf;
    private String nome;
    private Integer idade;

    public Treinador() {
    }

    public Treinador(TreinadorDto treinadorDto) {
        this.cpf = treinadorDto.getCpf();
        this.nome = treinadorDto.getNome();
        this.idade = treinadorDto.getIdade();
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

    public void atualiza(TreinadorDto treinadorDto) {

        if(treinadorDto.getNome() != null) {
            this.nome = treinadorDto.getNome();
        }

        if(treinadorDto.getIdade() != null) {
            this.idade = treinadorDto.getIdade();
        }

    }
}
