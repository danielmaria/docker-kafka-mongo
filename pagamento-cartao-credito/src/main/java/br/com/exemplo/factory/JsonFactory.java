package br.com.exemplo.factory;

import br.com.exemplo.dto.out.OutMovimentacaoFinanceira;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonFactory {
    private final ObjectMapper objectMapper;
    private static JsonFactory instance = null;

    private JsonFactory(){
        this.objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static JsonFactory getInstance() {
        if(instance == null) {
            instance = new JsonFactory();
        }
        return instance;
    }

    public String from(OutMovimentacaoFinanceira outMovimentacaoFinanceira){
        try {
            return objectMapper.writeValueAsString(outMovimentacaoFinanceira);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao mapear Json", e);
        }
    }
}
