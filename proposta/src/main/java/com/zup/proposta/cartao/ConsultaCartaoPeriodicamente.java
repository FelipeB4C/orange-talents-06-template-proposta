package com.zup.proposta.cartao;

import com.zup.proposta.proposta.Proposta;
import com.zup.proposta.proposta.PropostaRepository;
import com.zup.proposta.proposta.StatusProposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsultaCartaoPeriodicamente {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private CartaoClient cartaoClient;

    @Scheduled(fixedDelayString = "${periodicidade.executa-operacao}")
    public void consultaCartaoPeriodicamente() {

        List<Proposta> propostasAprovadasSemCartaoAssociado = propostaRepository.findByStatusPropostaAndCartaoIsNull(StatusProposta.ELEGIVEL);

        for (Proposta proposta : propostasAprovadasSemCartaoAssociado) {
            CartaoResponse idCartao = cartaoClient.consultaCartao(proposta.getId());
            proposta.setCartao(idCartao.getId());
            propostaRepository.save(proposta);
        }

    }

}
