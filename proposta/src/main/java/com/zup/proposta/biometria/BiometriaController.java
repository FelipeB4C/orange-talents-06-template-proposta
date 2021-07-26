package com.zup.proposta.biometria;

import com.zup.proposta.cartao.CartaoClient;
import com.zup.proposta.cartao.CartaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/biometrias")
public class BiometriaController {

    @Autowired
    private CartaoClient cartaoClient;

    @Autowired
    private BiometriaRepository biometriaRepository;

    @PostMapping("/{idCartao}")
    @Transactional
    public ResponseEntity<?> cadastrarBiometria(@PathVariable String idCartao, @RequestBody @Valid BiometriaRequest req){
        CartaoResponse cartaoResponse = cartaoClient.consultaCartaoSeExiste(idCartao);
        Biometria biometria = req.toModel(cartaoResponse.getId());

        biometriaRepository.save(biometria);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(biometria.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
