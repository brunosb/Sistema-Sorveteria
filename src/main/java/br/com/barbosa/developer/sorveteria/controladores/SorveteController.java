package br.com.barbosa.developer.sorveteria.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.barbosa.developer.sorveteria.excecoes.SorveteInvalidoException;
import br.com.barbosa.developer.sorveteria.modelo.entidades.Ingrediente;
import br.com.barbosa.developer.sorveteria.modelo.entidades.Sorvete;
import br.com.barbosa.developer.sorveteria.modelo.enumeracoes.CategoriaDeSorvete;
import br.com.barbosa.developer.sorveteria.modelo.repositories.IngredienteRepositorio;
import br.com.barbosa.developer.sorveteria.modelo.repositories.SorveteRepositorio;
import br.com.barbosa.developer.sorveteria.propertyeditors.IngredientePropertyEditor;

@Controller
@RequestMapping("/sorvetes")
public class SorveteController {
	
	@Autowired 
	private SorveteRepositorio sorveteRepositorio;
	
	@Autowired
	private IngredienteRepositorio ingredienteRepositorio;
	
	@Autowired
	private IngredientePropertyEditor ingredientePropertyEditor;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarSorvetes(Model model){
		model.addAttribute("sorvetes", sorveteRepositorio.findAll());
		model.addAttribute("categorias", CategoriaDeSorvete.values());
		model.addAttribute("ingredientes", ingredienteRepositorio.findAll());
		return "sorvete/listagem";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarSorvete(
			@Valid @ModelAttribute Sorvete sorvete,
			BindingResult bindingResult,
			Model model){
		
		if(bindingResult.hasErrors()){
			throw new SorveteInvalidoException();
		}else{
			sorveteRepositorio.save(sorvete);
		}
		
		model.addAttribute("sorvetes", sorveteRepositorio.findAll());		
		
		return "sorvete/tabela-sorvetes";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{sorveteId}")
	public ResponseEntity<String> deletarSorvete(@PathVariable Long sorveteId){
		try{
			sorveteRepositorio.delete(sorveteId);
			return new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity<Sorvete> buscarSorvete(@PathVariable Long id){
		Sorvete sorvete = sorveteRepositorio.findOne(id);
		return new ResponseEntity<Sorvete>(sorvete, HttpStatus.OK);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Ingrediente.class, ingredientePropertyEditor);
	}
	
	
}
