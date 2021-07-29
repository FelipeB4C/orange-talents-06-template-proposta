package com.zup.proposta.client;

import com.zup.proposta.aviso.AvisoRequest;
import com.zup.proposta.aviso.AvisoResponse;
import com.zup.proposta.bloqueio.BloqueioRequest;
import com.zup.proposta.bloqueio.BloqueioResponse;
import com.zup.proposta.cartao.CartaoResponse;
import com.zup.proposta.carteira.CarteiraResponse;
import com.zup.proposta.carteira.CarteiraRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "consultaCartao", url = "${local.consulta.cartao}")
public interface CartaoClient {

    @GetMapping(value = "${consulta.cartao}?idProposta={id}", consumes = "application/json")
    CartaoResponse consultaCartao(@PathVariable("id") String id);

    @GetMapping(value = "${consulta.cartao}/{id}", consumes = "application/json")
    CartaoResponse consultaCartaoSeExiste(@PathVariable("id") String id);

    @PostMapping(value = "${consulta.cartao}/{id}/bloqueios", consumes = "application/json")
    BloqueioResponse bloqueiaCartao(@PathVariable("id") String id, @RequestBody BloqueioRequest req);

    @PostMapping(value = "${consulta.cartao}/{id}/avisos", consumes = "application/json")
    AvisoResponse avisoViagem(@PathVariable("id") String id, @RequestBody AvisoRequest req);

    @PostMapping(value = "${consulta.cartao}/{id}/carteiras", consumes = "application/json")
    CarteiraResponse associaCarteira(@PathVariable("id") String id, @RequestBody CarteiraRequest req);

}
