package com.zup.proposta.bloqueio;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.zup.proposta.cartao.StatusCartao;

public class BloqueioResponse {

    private StatusCartao resultado;

    @Deprecated
    public BloqueioResponse(){}

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BloqueioResponse(StatusCartao resultado) {
        this.resultado = resultado;
    }

    public Bloqueio toModel(String ipClient, String userAgent){
        return new Bloqueio(resultado, ipClient, userAgent);
    }


    public StatusCartao getResultado() {
        return resultado;
    }


}
