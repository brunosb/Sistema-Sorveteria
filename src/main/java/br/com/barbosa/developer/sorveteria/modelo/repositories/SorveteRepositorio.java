package br.com.barbosa.developer.sorveteria.modelo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.barbosa.developer.sorveteria.modelo.entidades.Sorvete;

@Repository
public interface SorveteRepositorio extends CrudRepository<Sorvete, Long>{

	
	
}
