package com.zup.proposta.aviso;

import com.fasterxml.jackson.annotation.JsonCreator;

public class AvisoResponse {

    private StatusAviso resultado;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public AvisoResponse(StatusAviso resultado) {
        this.resultado = resultado;
    }

    public StatusAviso getResultado() {
        return resultado;
    }
}
