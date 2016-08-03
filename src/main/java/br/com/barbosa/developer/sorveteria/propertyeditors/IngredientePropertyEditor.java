package br.com.barbosa.developer.sorveteria.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.barbosa.developer.sorveteria.modelo.entidades.Ingrediente;
import br.com.barbosa.developer.sorveteria.modelo.repositories.IngredienteRepositorio;

@Component
public class IngredientePropertyEditor extends PropertyEditorSupport{

	@Autowired private IngredienteRepositorio ingredienteRepositorio;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		long idIngrediente = Long.parseLong(text);
		Ingrediente ingrediente = ingredienteRepositorio.findOne(idIngrediente);
		setValue(ingrediente);
	}
	
}
