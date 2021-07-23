package com.zup.proposta.proposta;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Optional;

public class PropostaResponse {

    private String documento, email, nome, endereco;
    private BigDecimal salario;
    private StatusProposta statusProposta;

    public PropostaResponse(){

    }

    public PropostaResponse(Proposta proposta) {
        this.documento = proposta.getDocumento();
        this.email = proposta.getEmail();
        this.nome = proposta.getNome();
        this.endereco = proposta.getEndereco();
        this.salario = proposta.getSalario();
        this.statusProposta = proposta.getStatusProposta();
    }

    public Proposta verificaSeExisteProposta(PropostaRepository repo, Long id){
        Optional<Proposta> proposta = repo.findById(id);
        return proposta.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public StatusProposta getStatusProposta() {
        return statusProposta;
    }
}
