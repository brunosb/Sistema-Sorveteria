package br.com.barbosa.developer.sorveteria.modelo.servicos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.barbosa.developer.sorveteria.modelo.entidades.Ingrediente;
import br.com.barbosa.developer.sorveteria.modelo.entidades.Sorvete;
import br.com.barbosa.developer.sorveteria.modelo.entidades.Sorveteria;
import br.com.barbosa.developer.sorveteria.modelo.repositories.SorveteRepositorio;

@Service
public class ServicoSorvete {

	@Autowired private SorveteRepositorio repositorio;
	@Autowired private ServicoSorveteria servicoSorveteria;
	
	public void salvar(Sorvete sorvete){
		sorvete.setDono(servicoSorveteria.getSorveteriaLogada());
		repositorio.save(sorvete);
	}
	
	public Iterable<Sorvete> listar(){
		Sorveteria dono = servicoSorveteria.getSorveteriaLogada();
		return repositorio.findAllByDono(dono);
	}
	
	public Sorvete buscar(long id){
		Sorveteria dono = servicoSorveteria.getSorveteriaLogada();
		return repositorio.findByIdAndDono(id, dono);
	}
	
	public void remover(long id){
		Sorvete sorvete = this.buscar(id);
		if(sorvete != null) repositorio.delete(sorvete);
	}

	public List<String> listarSorvetesDisponiveis() {
		List<Sorvete> sorvetes = repositorio.findAll();
		
		List<String> nomesSorvetes = sorvetes.stream().map((sorvete)->{
			return sorvete.getNome();
		}).sorted().collect(Collectors.toList());
		
		return nomesSorvetes;
	}
	
}
