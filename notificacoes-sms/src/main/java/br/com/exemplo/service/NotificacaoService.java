package br.com.exemplo.service;

import br.com.exemplo.dto.NotificacaoDTO;
import br.com.exemplo.repository.NotificacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificacaoService {
    private final NotificacaoRepository notificacaoRepository;

    public NotificacaoService(NotificacaoRepository notificacaoRepository) {
        this.notificacaoRepository = notificacaoRepository;
    }

    public List<NotificacaoDTO> findAll() {
        return notificacaoRepository.findAll().stream().map(NotificacaoDTO::new).collect(Collectors.toList());
    }
}
