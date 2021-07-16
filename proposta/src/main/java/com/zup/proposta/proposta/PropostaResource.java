package com.zup.proposta.proposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/propostas")
public class PropostaResource {

    @Autowired
    private PropostaRepository propostaRepo;

    @Transactional
    @PostMapping
    public ResponseEntity<?> cadastrarProposta(@RequestBody @Valid PropostaRequest req){
        Proposta existeDocumento =  req.verificaDocumento(propostaRepo);
        if(existeDocumento != null){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Documento não pode ser processado");
        }
        Proposta proposta = req.toModel();
        propostaRepo.save(proposta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(proposta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
