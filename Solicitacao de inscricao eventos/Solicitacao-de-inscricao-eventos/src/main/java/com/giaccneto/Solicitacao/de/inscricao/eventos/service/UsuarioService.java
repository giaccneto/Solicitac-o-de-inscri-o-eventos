package com.giaccneto.Solicitacao.de.inscricao.eventos.service;

import com.giaccneto.Solicitacao.de.inscricao.eventos.entities.Usuario;
import com.giaccneto.Solicitacao.de.inscricao.eventos.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;


    public Usuario criarUsuario(Usuario usuario) {
        try{
            emailExiste(usuario.getEmail());
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        }catch(RuntimeException e){
            throw new RuntimeException("Email ja cadastrado", e.getCause());
        }
    }

    private void emailExiste(String email) {
        try{
            boolean existe = usuarioRepository.existsByEmail(email);
        } catch (RuntimeException e) {
            throw new RuntimeException("Email ja cadastrado", e.getCause());
        }
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
