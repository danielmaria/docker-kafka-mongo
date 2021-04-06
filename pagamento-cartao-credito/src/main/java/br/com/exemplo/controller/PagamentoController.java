package br.com.exemplo.controller;

import br.com.exemplo.dto.in.InPagamentoCartaoCredito;
import br.com.exemplo.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    public ResponseEntity<Void> pagar(InPagamentoCartaoCredito inPagamentoCartaoCredito){
        pagamentoService.pagar(inPagamentoCartaoCredito);
        return ResponseEntity.accepted().build();
    }

}
