package com.zup.proposta.aviso;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Aviso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ipClient;
    private String userAgent;

    private LocalDateTime instanteDoAviso = LocalDateTime.now();

    public Aviso(String ipClient, String userAgent) {
        this.ipClient = ipClient;
        this.userAgent = userAgent;
    }
}
