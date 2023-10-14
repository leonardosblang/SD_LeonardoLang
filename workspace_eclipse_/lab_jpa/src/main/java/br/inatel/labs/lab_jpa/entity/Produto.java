package br.inatel.labs.lab_jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


import java.util.List;
import java.util.Objects;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(mappedBy = "listaProduto")
	private List<Fornecedor> lista_Fornecedor;
	
	@NotNull
	@Size(min = 2, max = 100)
	private String descricao;
	
	// construtores
	public Produto() {
		
	}
	
	public Produto(@NotNull @Size(min = 2, max = 100) String descricao) {
		super();
		this.descricao = descricao;
	}

	// Acessores
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Fornecedor> getListaFornecedor() {
		return lista_Fornecedor;
	}

	public void setListaFornecedor(List<Fornecedor> lista_Fornecedor) {
		this.lista_Fornecedor = lista_Fornecedor;
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
	
	
	
}
