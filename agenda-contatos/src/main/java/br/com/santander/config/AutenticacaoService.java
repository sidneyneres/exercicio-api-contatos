package br.com.santander.config;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.santander.model.Usuario;
import br.com.santander.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Usuario> usuario = usuarioRepository.findByEmail(username);
		if (usuario.isPresent()) {
			return usuario.get();
		}
		throw new UsernameNotFoundException("usuario não encontrado");
	}

	public Usuario buscarPorId(Integer id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));
	}

}
