package com.giaccneto.Solicitacao.de.inscricao.eventos.controller;

import com.giaccneto.Solicitacao.de.inscricao.eventos.entities.Evento;
import com.giaccneto.Solicitacao.de.inscricao.eventos.service.EventoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;

    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping
    public ResponseEntity<Evento> criarEvento(@RequestBody Evento evento){
        return ResponseEntity.ok(eventoService.criarEvento(evento));
    }

    @GetMapping("/{nomeEvento}")
    public ResponseEntity<Evento> buscarPorNome(@PathVariable String nomeEvento){
        return ResponseEntity.ok(eventoService.buscarPorNomeEvento(nomeEvento));
    }
    @DeleteMapping("/{nomeEvento}")
    public ResponseEntity<Void> deletarPorNome(@PathVariable String nomeEvento){
        eventoService.deletarEvento(nomeEvento);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{nomeEvento}")
    public ResponseEntity<Evento> atualizarEvento(
            @PathVariable String nomeEvento, @RequestBody Evento eventoAtualizado){
        Evento evento = eventoService.atualizarPorNome(nomeEvento, eventoAtualizado);
        return ResponseEntity.ok(evento);
    }
}
