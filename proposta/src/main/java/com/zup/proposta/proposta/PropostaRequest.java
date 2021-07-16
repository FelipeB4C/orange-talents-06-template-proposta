package com.zup.proposta.proposta;

import com.zup.proposta.validation.CpfOuCnpj;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Optional;

public class PropostaRequest {

    @CpfOuCnpj
    @NotBlank
    private String documento;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String endereco;

    @Positive
    @NotNull
    private BigDecimal salario;

    public PropostaRequest(String documento, String email, String nome, String endereco, BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    public Proposta toModel(){
        return new Proposta(this.documento, this.email, this.nome, this.endereco, this.salario);
    }

    public Proposta verificaDocumento(PropostaRepository repo){
        Optional<Proposta> proposta = repo.findByDocumento(documento);
        return proposta.orElse(null);
    }

}
