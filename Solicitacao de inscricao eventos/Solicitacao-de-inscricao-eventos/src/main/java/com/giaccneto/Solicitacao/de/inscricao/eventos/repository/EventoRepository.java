package com.giaccneto.Solicitacao.de.inscricao.eventos.repository;

import com.giaccneto.Solicitacao.de.inscricao.eventos.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    boolean existsByNomeEvento(String nomeEvento);
    Optional<Evento> findByNomeEvento(String nomeEvento);
    void deleteByNomeEvento(String nomeEvento);
}
