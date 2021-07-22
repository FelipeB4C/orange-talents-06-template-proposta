package com.zup.proposta.proposta;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ConsultaDadosResponse {

    private StatusConsulta resultadoSolicitacao;

    @JsonCreator( mode = JsonCreator.Mode.PROPERTIES)
    public ConsultaDadosResponse(StatusConsulta resultadoSolicitacao) {

        this.resultadoSolicitacao = resultadoSolicitacao;
    }

    public StatusConsulta getStatusConsulta() {
        return resultadoSolicitacao;
    }

}
