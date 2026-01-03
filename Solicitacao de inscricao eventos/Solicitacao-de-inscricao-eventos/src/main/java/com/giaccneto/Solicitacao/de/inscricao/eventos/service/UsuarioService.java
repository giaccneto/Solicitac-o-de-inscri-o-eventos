package com.giaccneto.Solicitacao.de.inscricao.eventos.service;

import com.giaccneto.Solicitacao.de.inscricao.eventos.entities.Usuario;
import com.giaccneto.Solicitacao.de.inscricao.eventos.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {

        Usuario usuarioExistente = usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
        usuarioExistente.setNome(usuarioAtualizado.getNome());
        usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        usuarioExistente.setAtivo(usuarioAtualizado.getAtivo());
        usuarioExistente.setCargo(usuarioAtualizado.getCargo());

        return usuarioRepository.save(usuarioExistente);
    }

    public Void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
        return null;
    }
}
