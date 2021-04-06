package br.com.exemplo.model;

import br.com.exemplo.dto.NotificacaoDTO;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Notificacao {
    private String id;
    private String mensagem;
    private String data;
    private String documentoAssociado;

    public Notificacao(NotificacaoDTO dto) {
        this.data = dto.getData();
        this.mensagem = dto.getMensagem();
        this.documentoAssociado = dto.getDocumentoAssociado();
    }

    public String getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDocumentoAssociado() {
        return documentoAssociado;
    }

    public void setDocumentoAssociado(String documentoAssociado) {
        this.documentoAssociado = documentoAssociado;
    }
}
