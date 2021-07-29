package com.zup.proposta.carteira;

import com.zup.proposta.carteira.StatusCateira;

public class CarteiraResponse {

    private StatusCateira resultado;
    private String id;

    public CarteiraResponse(StatusCateira resultado, String id) {
        this.resultado = resultado;
        this.id = id;
    }

    public StatusCateira getResultado() {
        return resultado;
    }

    public String getId() {
        return id;
    }

}
