package gov.br.ifsp.PerforMAX.dto;

import java.util.List;

public class RelatorioDto {

    private String nome;
    private List<TreinoDto> treinos;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<TreinoDto> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<TreinoDto> treinos) {
        this.treinos = treinos;
    }
}
