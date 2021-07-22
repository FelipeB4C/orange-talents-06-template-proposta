package com.zup.proposta.cartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "consultaCartao", url = "${local.consulta.cartao}")
public interface CartaoClient {

    @GetMapping(value = "${consulta.cartao}?idProposta={id}", consumes = "application/json")
    CartaoResponse consultaCartao(@PathVariable("id") Long id);
}
