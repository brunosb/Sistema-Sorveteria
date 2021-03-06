package br.com.barbosa.developer.sorveteria.modelo.entidades;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.barbosa.developer.sorveteria.modelo.enumeracoes.CategoriaDeSorvete;

@Entity
public class Sorvete {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="DONO")
	@JsonIgnore
	private Sorveteria dono;

	@NotNull
	@NotEmpty
	private String nome;
	
	@NotNull
	private Double preco;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private CategoriaDeSorvete categoria;

	@ManyToMany
	private Set<Ingrediente> ingredientes;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public CategoriaDeSorvete getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDeSorvete categoria) {
		this.categoria = categoria;
	}

	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public Sorveteria getDono() {
		return dono;
	}

	public void setDono(Sorveteria dono) {
		this.dono = dono;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sorvete other = (Sorvete) obj;
		if (categoria != other.categoria)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
	
}
