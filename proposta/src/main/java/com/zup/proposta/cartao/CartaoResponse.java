package com.zup.proposta.cartao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CartaoResponse {

    private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    private int limite;

    public CartaoResponse(String id, LocalDateTime emitidoEm, String titular, int limite) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.limite = limite;
    }

    public String getId() {
        return id;
    }

}
