package gov.br.ifsp.PerforMAX.model;

import gov.br.ifsp.PerforMAX.dto.TreinoDto;

public class TreinoTempo extends Treino {

    private String estiloNado;

    public TreinoTempo(TreinoDto treinoDto) {
        super();
        this.id = treinoDto.getId();
        this.data = treinoDto.getData();
        this.distancia = treinoDto.getDistancia();
        this.estiloNado = treinoDto.getEstiloNado();
    }

    public String getEstiloNado() {
        return estiloNado;
    }

    public void setEstiloNado(String estiloNado) {
        this.estiloNado = estiloNado;
    }
}
