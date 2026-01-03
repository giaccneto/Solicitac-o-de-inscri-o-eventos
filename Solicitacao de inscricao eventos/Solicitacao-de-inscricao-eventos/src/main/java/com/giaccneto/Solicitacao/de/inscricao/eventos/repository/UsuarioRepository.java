package com.giaccneto.Solicitacao.de.inscricao.eventos.repository;

import com.giaccneto.Solicitacao.de.inscricao.eventos.entities.Evento;
import com.giaccneto.Solicitacao.de.inscricao.eventos.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

}
