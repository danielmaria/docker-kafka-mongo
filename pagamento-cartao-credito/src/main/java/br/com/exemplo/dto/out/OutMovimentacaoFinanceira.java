package br.com.exemplo.dto.out;

import br.com.exemplo.dto.in.InPagamentoCartaoCredito;

import java.math.BigDecimal;

public class OutMovimentacaoFinanceira {

    private String documentoPagador;
    private BigDecimal valorPagamento;

    public static OutMovimentacaoFinanceira by(InPagamentoCartaoCredito inPagamentoCartaoCredito) {
        OutMovimentacaoFinanceira outMovimentacaoFinanceira = new OutMovimentacaoFinanceira();
        outMovimentacaoFinanceira.setDocumentoPagador(inPagamentoCartaoCredito.getDocumentoPagador());
        outMovimentacaoFinanceira.setValorPagamento(inPagamentoCartaoCredito.getValorPagamento());
        return outMovimentacaoFinanceira;
    }

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
