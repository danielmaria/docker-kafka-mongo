package br.com.exemplo.component;

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

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviar(String mensagem, String topico) {
        try {
            ListenableFuture<SendResult<String, String>> envio = kafkaTemplate.send(topico, mensagem);
            envio.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
                @Override
                public void onSuccess(SendResult<String, String> result) {
                    LOG.info("Mensagem {} enviada para o topico='{}'", mensagem, topico);
                }

                @Override
                public void onFailure(Throwable ex) {
                    LOG.error("Ocorreu um erro ao enviar a mensagem='{}' para o topico ='{}'", mensagem, topico);
                }
            });
        } catch (Exception e) {
            LOG.error("Ocorreu um erro ao enviar a mensagem='{}' para o topico ='{}'", mensagem, topico);
        }
    }

}
