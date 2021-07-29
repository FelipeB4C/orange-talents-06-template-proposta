package com.zup.proposta.carteira;

import com.zup.proposta.client.CartaoClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/carteiras")
public class CarteiraController {

    @Autowired
    private CartaoClient cartaoClient;

    @Autowired
    private CarteiraRepository carteiraRepository;


    @PostMapping("/paypal/{idCartao}")
    @Transactional
    public ResponseEntity<?> associaCarteira(@PathVariable("idCartao") String idCartao, @RequestBody @Valid CarteiraRequest req){

        req.setCarteira("Paypal");

        try {
            cartaoClient.consultaCartaoSeExiste(idCartao);
            CarteiraResponse carteiraResponse = cartaoClient.associaCarteira(idCartao, req);

            Carteira carteira = new Carteira(req.getEmail(), "Paypal");
            carteiraRepository.save(carteira);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(carteira.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (FeignException e){
            return ResponseEntity.status(e.status()).build();
        }

    }

}
