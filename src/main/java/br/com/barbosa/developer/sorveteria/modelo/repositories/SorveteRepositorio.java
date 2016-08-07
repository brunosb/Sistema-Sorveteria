package br.com.barbosa.developer.sorveteria.modelo.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.barbosa.developer.sorveteria.modelo.entidades.Sorvete;
import br.com.barbosa.developer.sorveteria.modelo.entidades.Sorveteria;

@Repository
public interface SorveteRepositorio extends CrudRepository<Sorvete, Long>{

	public List<Sorvete> findAllByDono(Sorveteria dono);
	
	public Sorvete findByIdAndDono(Long id, Sorveteria dono);
	
	public List<Sorvete> findAll();
	
}
