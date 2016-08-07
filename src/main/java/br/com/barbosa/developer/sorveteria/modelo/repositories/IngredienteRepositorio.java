package br.com.barbosa.developer.sorveteria.modelo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.barbosa.developer.sorveteria.modelo.entidades.Ingrediente;
import br.com.barbosa.developer.sorveteria.modelo.entidades.Sorveteria;

@Repository
public interface IngredienteRepositorio extends CrudRepository<Ingrediente, Long>{
	
	public List<Ingrediente> findAllByDono(Sorveteria dono);
	
	public Ingrediente findByIdAndDono(Long id, Sorveteria dono);
	
}
