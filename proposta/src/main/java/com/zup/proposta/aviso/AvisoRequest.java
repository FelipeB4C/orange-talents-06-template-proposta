package com.zup.proposta.aviso;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AvisoRequest {

    @NotBlank
    private String destino;

    @Future
    @NotNull
    private LocalDate validoAte;

    public AvisoRequest(String destino, LocalDate validoAte) {
        this.destino = destino;
        this.validoAte = validoAte;
    }

    public Aviso toModel(String userAgent, String ipClient){
        return new Aviso(ipClient, userAgent);
    }

}
