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
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        eventoService.deletarEvento(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizarEvento(
            @PathVariable Long id, @RequestBody Evento eventoAtualizado){
        Evento evento = eventoService.atualizarPorId(id, eventoAtualizado);
        return ResponseEntity.ok(evento);
    }
}
