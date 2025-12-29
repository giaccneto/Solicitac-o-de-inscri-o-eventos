package com.giaccneto.Solicitacao.de.inscricao.eventos.service;

import com.giaccneto.Solicitacao.de.inscricao.eventos.entities.Evento;
import com.giaccneto.Solicitacao.de.inscricao.eventos.exceptions.DataException;
import com.giaccneto.Solicitacao.de.inscricao.eventos.repository.EventoRepository;
import jdk.jfr.Event;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EventoService {


    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public Evento criarEvento(Evento evento){

        LocalDate hoje = LocalDate.now();

        if(evento.getDataInicio().isBefore(hoje)){
            throw  new DataException("A data de inicio não pode ser anterior data atual" + hoje);

        }
        if(evento.getDataFim().isBefore(evento.getDataInicio())){
            throw new DataException("A data de fim deve ser posterior a data inicio" + evento.getDataInicio());
        }

        return eventoRepository.save(evento);
    }
    public Evento buscarPorNomeEvento(String nomeEvento){
        return eventoRepository.findByNomeEvento(nomeEvento)
                .orElseThrow(()-> new RuntimeException("Evento não encontrado!"));
    }

    public void deletarEvento(Long id){
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Evento não encontrado"));
        eventoRepository.delete(evento);

    }

    public Evento atualizarPorId(Long id, Evento eventoAtualizado){
        Evento eventoExistente = eventoRepository.findById(id)
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
