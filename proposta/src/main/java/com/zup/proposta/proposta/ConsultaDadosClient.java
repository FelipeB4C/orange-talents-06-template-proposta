package com.zup.proposta.proposta;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "consultaRestricao", url = "${local.consulta.dados.restricao}" )
public interface ConsultaDadosClient {

    @PostMapping(value = "${consulta.dados.financeiros}", consumes = "application/json")
    ConsultaDadosResponse consultarDados(ConsultaDadosRequest request);

}
