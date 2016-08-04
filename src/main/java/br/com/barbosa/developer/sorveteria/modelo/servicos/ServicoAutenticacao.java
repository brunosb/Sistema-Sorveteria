package br.com.barbosa.developer.sorveteria.modelo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.barbosa.developer.sorveteria.modelo.repositories.UsuarioRepositorio;

@Service
public class ServicoAutenticacao implements UserDetailsService{

	@Autowired private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		return usuarioRepositorio.findOneByLogin(login);
	}

	
	
}
