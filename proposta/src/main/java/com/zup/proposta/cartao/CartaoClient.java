package com.zup.proposta.cartao;

import com.zup.proposta.bloqueio.BloqueioRequest;
import com.zup.proposta.bloqueio.BloqueioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "consultaCartao", url = "${local.consulta.cartao}")
public interface CartaoClient {

    @GetMapping(value = "${consulta.cartao}?idProposta={id}", consumes = "application/json")
    CartaoResponse consultaCartao(@PathVariable("id") Long id);

    @GetMapping(value = "${consulta.cartao}/{id}", consumes = "application/json")
    CartaoResponse consultaCartaoSeExiste(@PathVariable("id") String id);

    @PostMapping(value = "${consulta.cartao}/{id}/bloqueios", consumes = "application/json")
    BloqueioResponse bloqueiaCartao(@PathVariable("id") String id, @RequestBody BloqueioRequest req);
}
