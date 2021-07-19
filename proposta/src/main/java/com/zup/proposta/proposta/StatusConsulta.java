package com.zup.proposta.proposta;

public enum StatusConsulta {

    COM_RESTRICAO{
        StatusProposta retornaStatus() {
            return StatusProposta.NAO_ELEGIVEL;
        };
    },SEM_RESTRICAO{
        StatusProposta retornaStatus() {
            return StatusProposta.ELEGIVEL;
        };
    };
    abstract StatusProposta retornaStatus();

}
