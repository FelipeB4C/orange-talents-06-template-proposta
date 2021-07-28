package com.zup.proposta.bloqueio;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.zup.proposta.cartao.StatusCartao;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Bloqueio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private StatusCartao statusCartao;
    private String ipClient;
    private String userAgent;
    private LocalDateTime instanteDoBloqueio = LocalDateTime.now();

    public Bloqueio(StatusCartao statusCartao, String ipClient, String userAgent) {
        this.statusCartao = statusCartao;
        this.ipClient = ipClient;
        this.userAgent = userAgent;
    }

}
