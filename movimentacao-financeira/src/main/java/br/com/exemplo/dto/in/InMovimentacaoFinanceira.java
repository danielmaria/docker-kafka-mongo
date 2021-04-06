package br.com.exemplo.dto.in;

import java.math.BigDecimal;

public class InMovimentacaoFinanceira {

    private String documentoPagador;
    private BigDecimal valorPagamento;

    public String getDocumentoPagador() {
        return documentoPagador;
    }

    public void setDocumentoPagador(String documentoPagador) {
        this.documentoPagador = documentoPagador;
    }

    public BigDecimal getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(BigDecimal valorPagamento) {
        this.valorPagamento = valorPagamento;
    }
}
