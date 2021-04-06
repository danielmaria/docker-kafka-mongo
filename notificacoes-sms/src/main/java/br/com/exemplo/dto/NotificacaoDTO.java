package br.com.exemplo.dto;

import br.com.exemplo.model.Notificacao;

public class NotificacaoDTO {

    private String mensagem;
    private String data;
    private String documentoAssociado;

    public NotificacaoDTO(Notificacao dto) {
        this.data = dto.getData();
        this.mensagem = dto.getMensagem();
        this.documentoAssociado = dto.getDocumentoAssociado();
    }


    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDocumentoAssociado() {
        return documentoAssociado;
    }

    public void setDocumentoAssociado(String documentoAssociado) {
        this.documentoAssociado = documentoAssociado;
    }
}
