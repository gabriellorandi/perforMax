package gov.br.ifsp.PerforMAX.model;

import gov.br.ifsp.PerforMAX.dto.TreinoDto;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "treino")
public class Treino {

    @Id
    protected Long id;
    protected ZonedDateTime data;
    protected Double distancia;

    @OneToOne
    private Treinador treinador;

    @ManyToMany
    private List<Nadador> nadadores;

    public Treino() {
        nadadores = new ArrayList<>();
    }

    public boolean isFisico() {
        return this instanceof TreinoFisico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getData() {
        return data;
    }

    public void setData(ZonedDateTime data) {
        this.data = data;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Treinador getTreinador() {
        return treinador;
    }

    public void setTreinador(Treinador treinador) {
        this.treinador = treinador;
    }

    public List<Nadador> getNadadores() {
        return nadadores;
    }

    public void setNadadores(List<Nadador> nadadores) {
        this.nadadores = nadadores;
    }

    public void atualizaFisico(TreinoDto treinoDto) {

        if(treinoDto.getData() != null) {
            this.data = treinoDto.getData();
        }

        if(treinoDto.getDistancia() != null) {
            this.distancia = treinoDto.getDistancia();
        }

        if(treinoDto.getTempo() != null) {
            ((TreinoFisico) this).setTempo(treinoDto.getTempo());
        }

    }

    public void atualizaTempo(TreinoDto treinoDto) {

        if(treinoDto.getData() != null) {
            this.data = treinoDto.getData();
        }

        if(treinoDto.getDistancia() != null) {
            this.distancia = treinoDto.getDistancia();
        }

        if(treinoDto.getEstiloNado() != null) {
            ((TreinoTempo) this).setEstiloNado(treinoDto.getEstiloNado());
        }

    }
}
