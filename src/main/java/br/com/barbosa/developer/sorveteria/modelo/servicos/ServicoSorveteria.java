package br.com.barbosa.developer.sorveteria.modelo.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.barbosa.developer.sorveteria.modelo.entidades.Sorveteria;
import br.com.barbosa.developer.sorveteria.modelo.repositories.SorveteriaRepositorio;

@Service
public class ServicoSorveteria {

	@Autowired private SorveteriaRepositorio sorveteriaRepositorio;
	
	public Sorveteria getSorveteriaLogada(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication == null){
			throw new AuthenticationCredentialsNotFoundException("Usuario nao Logado");
		}
		
		UserDetails usuarioLogado = (UserDetails) authentication.getPrincipal();
		return sorveteriaRepositorio.findOneByLogin(usuarioLogado.getUsername());
		
	}

	/*public List<Sorveteria> listarSorveteriasQueContem(String nomeSorvete) {
		return sorveteriaRepositorio.listarSorveteriasPorNomeSorvete(nomeSorvete);		
	}*/
	
}
