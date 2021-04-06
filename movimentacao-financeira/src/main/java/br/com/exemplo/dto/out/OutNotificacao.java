package br.com.exemplo.dto.out;

import br.com.exemplo.dto.in.InMovimentacaoFinanceira;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OutNotificacao {
    private String mensagem;
    private String data;
    private String documentoAssociado;

    public static OutNotificacao by(InMovimentacaoFinanceira inMovimentacaoFinanceira) {
        OutNotificacao outNotificacao = new OutNotificacao();
        outNotificacao.setData(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        outNotificacao.setDocumentoAssociado(inMovimentacaoFinanceira.getDocumentoPagador());
        outNotificacao.setMensagem(MessageFormat.format("O pagamento de {0} foi efetuado com sucesso", inMovimentacaoFinanceira.getValorPagamento()));
        return outNotificacao;
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
