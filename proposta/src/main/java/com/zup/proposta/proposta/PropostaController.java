package com.zup.proposta.proposta;

import com.zup.proposta.client.CartaoClient;
import com.zup.proposta.client.ConsultaDadosClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

    @Autowired
    private ConsultaDadosClient consultaDadosInterface;

    @Autowired
    private CartaoClient cartaoClient;

    @Autowired
    private PropostaRepository propostaRepo;

    @Transactional
    @PostMapping()
    public ResponseEntity<?> cadastrarProposta(@RequestBody @Valid PropostaRequest req) {

        Proposta existeDocumento = req.verificaDocumento(propostaRepo);
        if (existeDocumento != null) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Documento não pode ser processado");
        }
        Proposta proposta = req.toModel();
        propostaRepo.save(proposta);

        try {
            ConsultaDadosResponse dadosResponse = consultaDadosInterface.consultarDados(new ConsultaDadosRequest(proposta));
            proposta.setStatusProposta(dadosResponse.getStatusConsulta());
        } catch (FeignException e) {
            proposta.setStatusProposta(StatusProposta.NAO_ELEGIVEL);
            return ResponseEntity.status(e.status()).build();
        }

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(proposta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> acompanhaProposta(@PathVariable Long id){
        Proposta proposta = new PropostaResponse().verificaSeExisteProposta(propostaRepo, id);
        PropostaResponse response = new PropostaResponse(proposta);
        return ResponseEntity.ok().body(response);
    }


}
