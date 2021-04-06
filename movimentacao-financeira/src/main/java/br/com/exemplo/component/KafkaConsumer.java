package br.com.exemplo.component;

import br.com.exemplo.dto.in.InMovimentacaoFinanceira;
import br.com.exemplo.service.MovimentacaoFinanceiraService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);

    private final Gson jsonConverter;
    private final MovimentacaoFinanceiraService movimentacaoFinanceiraService;

    public KafkaConsumer(Gson jsonConverter, MovimentacaoFinanceiraService movimentacaoFinanceiraService) {
        this.jsonConverter = jsonConverter;
        this.movimentacaoFinanceiraService = movimentacaoFinanceiraService;
    }

    @KafkaListener(topics = "movimentacao-financeira-v1",
            containerFactory ="kafkaListenerContainerFactory",
            concurrency = "1",
            groupId = "movimentacao-financeira")
    public void getFromKafka(String model){
        InMovimentacaoFinanceira movimentacaoFinanceira = jsonConverter.fromJson(model, InMovimentacaoFinanceira.class);
        movimentacaoFinanceiraService.processar(movimentacaoFinanceira);
        LOG.info("Mensagem {} recebida na aplicação de movimentações fincanceiras", model);
    }

}
