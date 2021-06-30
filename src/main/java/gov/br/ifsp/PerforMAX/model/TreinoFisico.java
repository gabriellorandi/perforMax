package gov.br.ifsp.PerforMAX.model;

import gov.br.ifsp.PerforMAX.dto.TreinoDto;

import java.time.ZonedDateTime;

public class TreinoFisico extends Treino {

    private ZonedDateTime tempo;

    public TreinoFisico(TreinoDto treinoDto) {
        super();
        this.id = treinoDto.getId();
        this.data = treinoDto.getData();
        this.distancia = treinoDto.getDistancia();
        this.tempo = treinoDto.getTempo();
    }

    public ZonedDateTime getTempo() {
        return tempo;
    }

    public void setTempo(ZonedDateTime tempo) {
        this.tempo = tempo;
    }
}
