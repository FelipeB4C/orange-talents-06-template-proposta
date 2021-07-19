package com.zup.proposta.proposta;

public class ConsultaDadosRequest {

    private Long idProposta;
    private String documento;
    private String nome;

    public ConsultaDadosRequest(Proposta proposta) {
        this.idProposta = proposta.getId();
        this.documento = proposta.getDocumento();
        this.nome = proposta.getNome();
    }


    public Long getIdProposta() {
        return idProposta;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

}
