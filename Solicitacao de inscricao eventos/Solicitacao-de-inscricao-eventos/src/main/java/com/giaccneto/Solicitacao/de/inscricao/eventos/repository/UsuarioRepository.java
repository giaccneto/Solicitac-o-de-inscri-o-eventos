package com.giaccneto.Solicitacao.de.inscricao.eventos.repository;

import com.giaccneto.Solicitacao.de.inscricao.eventos.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
