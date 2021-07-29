package com.zup.proposta.aviso;

import com.zup.proposta.client.CartaoClient;
import com.zup.proposta.util.IPAddress;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/avisos")
public class AvisoController {

    @Autowired
    private CartaoClient cartaoClient;

    @Autowired
    private AvisoRepository avisoRepository;

    @PostMapping("/{idCartao}")
    @Transactional
    public ResponseEntity<?> cadastrarAviso(@PathVariable("idCartao") String idCartao,
                                            @RequestBody @Valid AvisoRequest req,
                                            @RequestHeader("User-Agent") String userAgent,
                                            HttpServletRequest http) {
        System.out.println(idCartao);
        try {
            cartaoClient.consultaCartaoSeExiste(idCartao);
            AvisoResponse resultado = cartaoClient.avisoViagem(idCartao, req);
            Aviso aviso = req.toModel(userAgent, IPAddress.getClientIp(http));
            avisoRepository.save(aviso);
            return ResponseEntity.ok(resultado.getResultado());
        } catch (FeignException e) {
            return ResponseEntity.status(e.status()).build();
        }

    }

}
