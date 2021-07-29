package com.zup.proposta.bloqueio;

import com.zup.proposta.client.CartaoClient;
import com.zup.proposta.util.IPAddress;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/bloqueios")
public class BloqueioController {

    @Autowired
    private CartaoClient cartaoClient;

    @Autowired
    private BloqueioRepository bloqueioRepository;

    @PostMapping("/{idCartao}")
    @Transactional
    public ResponseEntity<?> bloqueiaCartao(@PathVariable String idCartao,
                                            @RequestHeader(value="User-Agent") String userAgent,
                                            HttpServletRequest http){

        try{
            cartaoClient.consultaCartaoSeExiste(idCartao);
            BloqueioRequest request = new BloqueioRequest("sistema-proposta/orange-talents");
            BloqueioResponse statusCartao = cartaoClient.bloqueiaCartao(idCartao, request);
            Bloqueio bloqueio = statusCartao.toModel(IPAddress.getClientIp(http), userAgent);
            bloqueioRepository.save(bloqueio);

            return ResponseEntity.ok().body(statusCartao.getResultado());
        } catch (FeignException e){
            return ResponseEntity.status(e.status()).build();
        }

    }


}
