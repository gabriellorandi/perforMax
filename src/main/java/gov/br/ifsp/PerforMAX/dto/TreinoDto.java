package gov.br.ifsp.PerforMAX.dto;


import gov.br.ifsp.PerforMAX.model.Treino;
import gov.br.ifsp.PerforMAX.model.TreinoFisico;
import gov.br.ifsp.PerforMAX.model.TreinoTempo;

import java.time.ZonedDateTime;

public class TreinoDto {

    private Long id;
    private ZonedDateTime data;
    private Double distancia;
    private ZonedDateTime tempo;
    private String estiloNado;

    private TreinadorDto treinadorDto;

    public TreinoDto(TreinoFisico treinoFisico) {
        this.id = treinoFisico.getId();
        this.data = treinoFisico.getData();
        this.distancia = treinoFisico.getDistancia();
        this.tempo = treinoFisico.getTempo();
    }

    public TreinoDto(TreinoTempo treinoTempo) {
        this.id = treinoTempo.getId();
        this.data = treinoTempo.getData();
        this.distancia = treinoTempo.getDistancia();
        this.estiloNado = treinoTempo.getEstiloNado();
    }

    public TreinoDto(Treino treino) {
        this.id = treino.getId();
        this.data = treino.getData();
        this.distancia = treino.getDistancia();

        if(treino.getTreinador() != null) {
            this.treinadorDto = new TreinadorDto(treino.getTreinador());
        }
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

    public ZonedDateTime getTempo() {
        return tempo;
    }

    public void setTempo(ZonedDateTime tempo) {
        this.tempo = tempo;
    }

    public String getEstiloNado() {
        return estiloNado;
    }

    public void setEstiloNado(String estiloNado) {
        this.estiloNado = estiloNado;
    }

    public TreinadorDto getTreinadorDto() {
        return treinadorDto;
    }

    public void setTreinadorDto(TreinadorDto treinadorDto) {
        this.treinadorDto = treinadorDto;
    }
}
