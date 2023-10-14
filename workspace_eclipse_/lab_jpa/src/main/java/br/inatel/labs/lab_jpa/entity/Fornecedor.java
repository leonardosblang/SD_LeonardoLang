package br.inatel.labs.lab_jpa.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
		
	@NotNull
	@Size(min = 2, max = 200)
	private String razao_Social;
	
	@ManyToMany
	private List<Produto> lista_Produto;
	
	public Fornecedor() {
		
	}
	
	public Fornecedor(String razao_Social) {
		super();
		this.razao_Social = razao_Social;
	}

	// Acessores
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razao_Social;
	}

	public void setRazaoSocial(String razao_Social) {
		this.razao_Social = razao_Social;
	}

	public List<Produto> getListaProduto() {
		return lista_Produto;
	}

	public void setListaProduto(List<Produto> lista_Produto) {
		this.lista_Produto = lista_Produto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", razao_Social=" + razao_Social + "]";
	}
	
	
	
	
	
}
