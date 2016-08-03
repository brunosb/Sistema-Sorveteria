package br.com.barbosa.developer.sorveteria.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.barbosa.developer.sorveteria.excecoes.IngredienteInvalidoException;
import br.com.barbosa.developer.sorveteria.modelo.entidades.Ingrediente;
import br.com.barbosa.developer.sorveteria.modelo.enumeracoes.CategoriaDeIngrediente;
import br.com.barbosa.developer.sorveteria.modelo.repositories.IngredienteRepositorio;

@Controller
@RequestMapping("/ingredientes")
public class IngredienteController {

	@Autowired private IngredienteRepositorio ingredienteRepositorio;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarIngredientes(Model model){
		Iterable<Ingrediente> ingredientes = ingredienteRepositorio.findAll();
		model.addAttribute("ingredientes", ingredientes);
		model.addAttribute("categorias",CategoriaDeIngrediente.values());
		return "ingrediente/listagem";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarIngrediente(
			@Valid @ModelAttribute Ingrediente ingrediente,
			BindingResult bindingResult,
			//RedirectAttributes redirectAttributes,
			Model model){
		
		if(bindingResult.hasErrors()){
			/*FieldError error = bindingResult.getFieldErrors().get(0);
			redirectAttributes.addFlashAttribute("msgErro", "Não foi possível salvar o Ingrediente! "+error.getField()+" "+error.getDefaultMessage());*/
			
			throw new IngredienteInvalidoException();
			
		}else{
			ingredienteRepositorio.save(ingrediente);
			//redirectAttributes.addFlashAttribute("msgInfo", "O Ingrediente foi salvo!");
			
		}
		

		model.addAttribute("ingredientes", ingredienteRepositorio.findAll());
		model.addAttribute("categorias",CategoriaDeIngrediente.values());
		
		//return "redirect:/app/ingredientes";
		return "ingrediente/tabela-ingredientes";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarIngrediente(@PathVariable Long id){
		try{
			ingredienteRepositorio.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Ingrediente buscarIngrediente(@PathVariable Long id){
		return ingredienteRepositorio.findOne(id);
	}
	
	
}
