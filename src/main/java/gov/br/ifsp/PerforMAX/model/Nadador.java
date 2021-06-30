package gov.br.ifsp.PerforMAX.model;

import gov.br.ifsp.PerforMAX.dto.NadadorDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity(name = "nadador")
public class Nadador {

    @Id
    private Long cpf;
    private String nome;
    private Integer idade;
    private String especialidade;

    @ManyToMany
    private List<Treino> treinos;

    public Nadador(NadadorDto nadadorDto) {
        this.cpf = nadadorDto.getCpf();
        this.nome = nadadorDto.getNome();
        this.idade = nadadorDto.getIdade();
        this.especialidade = nadadorDto.getEspecialidade();
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

    public void atualiza(NadadorDto nadadorDto) {

        if(nadadorDto.getNome() != null) {
            this.nome = nadadorDto.getNome();
        }

        if(nadadorDto.getIdade() != null) {
            this.idade = nadadorDto.getIdade();
        }

        if(nadadorDto.getEspecialidade() != null) {
            this.especialidade = nadadorDto.getEspecialidade();
        }

    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }
}
