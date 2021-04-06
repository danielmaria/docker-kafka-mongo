package br.com.exemplo.service;

import br.com.exemplo.component.KafkaSender;
import br.com.exemplo.dto.in.InPagamentoCartaoCredito;
import br.com.exemplo.dto.out.OutMovimentacaoFinanceira;
import br.com.exemplo.factory.JsonFactory;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    private String topicName = "movimentacao-financeira-v1";

    private final KafkaSender kafkaSender;

    public PagamentoService(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    public void pagar(InPagamentoCartaoCredito inPagamentoCartaoCredito) {
        OutMovimentacaoFinanceira outMovimentacaoFinanceira = OutMovimentacaoFinanceira.by(inPagamentoCartaoCredito);
        String mensagem = JsonFactory.getInstance().from(outMovimentacaoFinanceira);
        kafkaSender.enviar(mensagem, topicName);
    }
}
