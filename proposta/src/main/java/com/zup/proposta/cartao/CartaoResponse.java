package com.zup.proposta.cartao;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CartaoResponse {

    private String id;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CartaoResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
