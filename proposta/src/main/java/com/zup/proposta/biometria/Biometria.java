package com.zup.proposta.biometria;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Biometria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataBiometriaAssociada = LocalDate.now();

    @Column(columnDefinition = "LONGTEXT")
    @NotBlank
    private String biometriaBase64;

    @NotBlank
    private String cartao;

    public Biometria(String biometriaBase64, String cartao) {
        this.biometriaBase64 = biometriaBase64;
        this.cartao = cartao;
    }

    public Long getId() {
        return id;
    }

}
