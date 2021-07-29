package com.zup.proposta.carteira;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private LocalDateTime associadaEm = LocalDateTime.now();
    private String emissor;

    public Carteira(String email, String emissor) {
        this.email = email;
        this.emissor = emissor;
    }

    public Long getId() {
        return id;
    }
}
