package br.inatel.labs.lab_jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
public class NotaCompra {
	
	@Id
	private Long id;
	
	@NotNull
	@Past
	private LocalDate data_Emissao;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	public NotaCompra() {
		
	}
	
	public NotaCompra(@NotNull @Past LocalDate data_Emissao, Fornecedor fornecedor) {
		super();
		this.data_Emissao = data_Emissao;
		this.fornecedor = fornecedor;
	}

	// acessores
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataEmissao() {
		return data_Emissao;
	}

	public void setDataEmissao(LocalDate data_Emissao) {
		this.data_Emissao = data_Emissao;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<NotaCompraItem> getListaNotaCompraItem() {
		return lista_Nota_Compra_Item;
	}

	public void setListaNotaCompraItem(List<NotaCompraItem> lista_Nota_Compra_Item) {
		this.lista_Nota_Compra_Item = lista_Nota_Compra_Item;
	}

	@OneToMany(mappedBy = "notaCompra")
	private List<NotaCompraItem> lista_Nota_Compra_Item;
	
	public BigDecimal getCalculoTotalNota() {
		BigDecimal totalNota = lista_Nota_Compra_Item.stream()
			.map(i -> i.getCalculoTotalItem())
			.reduce(BigDecimal.ZERO, BigDecimal :: add);
		return totalNota;
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
		NotaCompra other = (NotaCompra) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "NotaCompra [id=" + id + ", data_Emissao=" + data_Emissao + "]";
	}
	
	
	
	
	
}
