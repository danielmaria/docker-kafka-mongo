package br.com.exemplo.component;

import br.com.exemplo.dto.out.OutNotificacao;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaSender {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaSender.class);

    private String topicName = "notificacoes-v1";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Gson jsonConverter;

    public KafkaSender(KafkaTemplate<String, String> kafkaTemplate, Gson jsonConverter) {
        this.kafkaTemplate = kafkaTemplate;
        this.jsonConverter = jsonConverter;
    }

    public void enviar(OutNotificacao outNotificacao) {
        try {
            String mensagem = jsonConverter.toJson(outNotificacao);
            ListenableFuture<SendResult<String, String>> envio = kafkaTemplate.send(topicName, mensagem);
            envio.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
                @Override
                public void onSuccess(SendResult<String, String> result) {
                    LOG.info("Mensagem {} enviada para o topico='{}'", mensagem, topicName);
                }

                @Override
                public void onFailure(Throwable ex) {
                    LOG.error("Ocorreu um erro ao enviar a mensagem='{}' para o topico ='{}'", mensagem, topicName);
                }
            });
        } catch (Exception e) {
            LOG.error("Ocorreu um erro ao enviar a mensagem='{}' para o topico ='{}'", jsonConverter.toJson(outNotificacao), topicName);
        }
    }

}
