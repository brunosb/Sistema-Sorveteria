package br.com.barbosa.developer.sorveteria.modelo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbosa.developer.sorveteria.modelo.entidades.Ingrediente;
import br.com.barbosa.developer.sorveteria.modelo.entidades.Sorveteria;
import br.com.barbosa.developer.sorveteria.modelo.repositories.IngredienteRepositorio;

@Service
public class ServicoIngrediente {

	@Autowired private IngredienteRepositorio repositorio;
	@Autowired private ServicoSorveteria servicoSorveteria;
	
	public void salvar(Ingrediente ingrediente){
		ingrediente.setDono(servicoSorveteria.getSorveteriaLogada());
		repositorio.save(ingrediente);		
	}
	
	public Iterable<Ingrediente> listar(){
		Sorveteria dono = servicoSorveteria.getSorveteriaLogada();
		return repositorio.findAllByDono(dono);
	}
	
	public Ingrediente buscar(long id){
		Sorveteria dono = servicoSorveteria.getSorveteriaLogada();
		return repositorio.findByIdAndDono(id, dono);
	}
	
	public void remover(long id){
		Ingrediente ingrediente = this.buscar(id);
		if(ingrediente != null) repositorio.delete(ingrediente);
	}
	
}
