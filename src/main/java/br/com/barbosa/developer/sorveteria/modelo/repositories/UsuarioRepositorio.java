package br.com.barbosa.developer.sorveteria.modelo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.barbosa.developer.sorveteria.modelo.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{

	public Usuario findOneByLogin(String login);

}
