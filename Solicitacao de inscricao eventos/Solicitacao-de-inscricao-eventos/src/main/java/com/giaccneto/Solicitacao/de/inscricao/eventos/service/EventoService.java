package com.giaccneto.Solicitacao.de.inscricao.eventos.service;

import com.giaccneto.Solicitacao.de.inscricao.eventos.entities.Evento;
import com.giaccneto.Solicitacao.de.inscricao.eventos.repository.EventoRepository;
import jdk.jfr.Event;
import org.springframework.stereotype.Service;

@Service
public class EventoService {


    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Evento criarEvento(Evento evento){
        return eventoRepository.save(evento);
    }
    public Evento buscarPorNomeEvento(String nomeEvento){
        return eventoRepository.findByNomeEvento(nomeEvento)
                .orElseThrow(()-> new RuntimeException("Evento não encontrado!"));
    }

    public void deletarEvento(String nomeEvento){
        Evento evento = eventoRepository.findByNomeEvento(nomeEvento)
                .orElseThrow(()-> new RuntimeException("Evento não encontrado"));
        eventoRepository.delete(evento);

    }

    public Evento atualizarPorNome(String nomeEvento, Evento eventoAtualizado){
        Evento eventoExistente = eventoRepository.findByNomeEvento(nomeEvento)
                .orElseThrow(()->new RuntimeException("Evento não encontrado!"));

        //O CODIGO ABAIXO É A PARTE QUE ATUALIZA O EVENTO
        eventoExistente.setNomeEvento(eventoAtualizado.getNomeEvento());
        eventoExistente.setPublicoAlvo(eventoAtualizado.getPublicoAlvo());
        eventoExistente.setCh(eventoAtualizado.getCh());
        eventoExistente.setLocal(eventoAtualizado.getLocal());
        eventoExistente.setDataInicio(eventoAtualizado.getDataInicio());
        eventoExistente.setDataFim(eventoAtualizado.getDataFim());

        return eventoRepository.save(eventoExistente);

    }

}
