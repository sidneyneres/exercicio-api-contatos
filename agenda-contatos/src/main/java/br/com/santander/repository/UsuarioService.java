package br.com.santander.repository;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.santander.model.Usuario;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario buscarPorEmail(String username) {
		return usuarioRepository.findByEmail(username)
				.orElseThrow(() -> new EntityNotFoundException("Usuário #{username} não encontrado"));
	}

	public Usuario buscarPorId(Integer id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Usuário #{username} não encontrado"));
	}

}

