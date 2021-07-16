package com.zup.proposta.handler;

public class ErroDeFormulario {

    private String atributo;
    private String msgErro;

    public ErroDeFormulario(String atributo, String msgErro) {
        this.atributo = atributo;
        this.msgErro = msgErro;
    }

    public String getatributo() {
        return atributo;
    }

    public String getMsgErro() {
        return msgErro;
    }

}
