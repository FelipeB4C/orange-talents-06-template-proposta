package com.zup.proposta.biometria;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class BiometriaRequest {

    @NotBlank
    private String biometriaBase64;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BiometriaRequest(String biometriaBase64) {
        this.biometriaBase64 = Base64.getEncoder().encodeToString(biometriaBase64.getBytes(StandardCharsets.UTF_8));
    }

    public Biometria toModel(String cartao){
        return new Biometria(biometriaBase64, cartao);
    }

    public String getBiometriaBase64() {
        return biometriaBase64;
    }
}
