package br.com.barbosa.developer.sorveteria.modelo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.barbosa.developer.sorveteria.modelo.entidades.Sorveteria;

@Repository
public interface SorveteriaRepositorio extends CrudRepository<Sorveteria, Long>{

	public Sorveteria findOneByLogin(String login);

	//@Query("SELECT sorveteria.*,sorvete.* FROM sorveteria INNER JOIN sorveteria.sorvetes WHERE sorveteria.sorvete.nome = ?")
	//public List<Sorveteria> listarSorveteriasPorNomeSorvete(String nomeSorvete);
}
