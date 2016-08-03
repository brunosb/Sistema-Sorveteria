package br.com.barbosa.developer.sorveteria.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class SorveteInvalidoException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

}
