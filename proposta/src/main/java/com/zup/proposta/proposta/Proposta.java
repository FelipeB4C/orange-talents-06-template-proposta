package com.zup.proposta.proposta;

import com.zup.proposta.validation.CpfOuCnpj;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Enumerated(EnumType.STRING)
    private StatusProposta statusProposta;

    private String cartao;

    @Deprecated
    public Proposta() {

    }

    public Proposta(String documento, String email, String nome, String endereco, BigDecimal salario) {
        this.documento = new BCryptPasswordEncoder().encode(documento);
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    public Long getId() {
        return id;
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


    public void setStatusProposta(StatusConsulta statusConsulta) {
        this.statusProposta = statusConsulta.retornaStatus();
    }

    public void setStatusProposta(StatusProposta statusProposta) {
        this.statusProposta = statusProposta;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }
}
