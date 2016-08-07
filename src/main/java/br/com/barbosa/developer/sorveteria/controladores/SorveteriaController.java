package br.com.barbosa.developer.sorveteria.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.barbosa.developer.sorveteria.modelo.servicos.ServicoSorvete;
import br.com.barbosa.developer.sorveteria.modelo.servicos.ServicoSorveteria;

@Controller
@RequestMapping("/sorveterias")
public class SorveteriaController { // Com problema na Syntax SQL

	@Autowired private ServicoSorveteria servicoSorveteria;
	@Autowired private ServicoSorvete servicoSorvete;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model){
		
		model.addAttribute("nomesSorvetes",servicoSorvete.listarSorvetesDisponiveis());
		return "cliente/busca_sorveterias";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/sorvete/{nomeSorvete}")
	public String index(@PathVariable String nomeSorvete, Model model){
		//model.addAttribute("sorveterias", servicoSorveteria.listarSorveteriasQueContem(nomeSorvete));
		
		return "cliente/tabela_sorveterias";
	}
	
}
