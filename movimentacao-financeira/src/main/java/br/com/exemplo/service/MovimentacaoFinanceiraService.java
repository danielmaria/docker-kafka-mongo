package br.com.exemplo.service;

import br.com.exemplo.component.KafkaSender;
import br.com.exemplo.dto.in.InMovimentacaoFinanceira;
import br.com.exemplo.dto.out.OutNotificacao;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoFinanceiraService {
    private final KafkaSender kafkaSender;

    public MovimentacaoFinanceiraService(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    private void enviarAvisoNotificacao(InMovimentacaoFinanceira inMovimentacaoFinanceira) {
        OutNotificacao outNotificacao = OutNotificacao.by(inMovimentacaoFinanceira);
        kafkaSender.enviar(outNotificacao);
    }

    public void processar(InMovimentacaoFinanceira simpleModel) {
        //Processo oculto ...
        enviarAvisoNotificacao(simpleModel);
    }
}
