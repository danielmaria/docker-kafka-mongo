package br.com.exemplo.component;

import br.com.exemplo.dto.NotificacaoDTO;
import br.com.exemplo.model.Notificacao;
import br.com.exemplo.repository.NotificacaoRepository;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);

    private final Gson jsonConverter;
    private final NotificacaoRepository notificacaoRepository;

    public KafkaConsumer(Gson jsonConverter, NotificacaoRepository notificacaoRepository) {
        this.jsonConverter = jsonConverter;
        this.notificacaoRepository = notificacaoRepository;
    }

    @KafkaListener(topics = "notificacoes-v1")
    public void recebendoNotificacao(String mensagem){
        NotificacaoDTO simpleModel = jsonConverter.fromJson(mensagem, NotificacaoDTO.class);
        Notificacao notificacao = new Notificacao(simpleModel);
        notificacaoRepository.save(notificacao);
        LOG.info("Mensagem {} recebida", mensagem);
    }

}
