package com.zup.proposta.carteira;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CarteiraRequest {


    @Email
    @NotBlank
    private String email;

    private String carteira;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CarteiraRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getCarteira() {
        return carteira;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

}
