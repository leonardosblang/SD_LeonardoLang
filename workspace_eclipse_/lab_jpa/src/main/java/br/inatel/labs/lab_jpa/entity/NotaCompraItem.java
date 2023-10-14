package br.inatel.labs.lab_jpa.entity;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class NotaCompraItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Positive
	private BigDecimal valor_Compra_Produto;
	
	@NotNull
	@Positive
	private Integer quantidade;
	
	@ManyToOne
	private NotaCompra nota_Compra;
	
	@ManyToOne
	private Produto produto;
	
	public BigDecimal getCalculoTotalItem() {
		return valor_Compra_Produto.multiply( BigDecimal.valueOf( quantidade ) );
	}
	

	public NotaCompraItem(@NotNull @Positive BigDecimal valor_Compra_Produto, @NotNull @Positive Integer quantidade,
			NotaCompra nota_Compra, Produto produto) {
		super();
		this.valor_Compra_Produto = valor_Compra_Produto;
		this.quantidade = quantidade;
		this.nota_Compra = nota_Compra;
		this.produto = produto;
	}



	public NotaCompraItem(NotaCompra nc1, Produto p1, BigDecimal bigDecimal, int i) {
		
	}


	// acessores
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorCompraProduto() {
		return valor_Compra_Produto;
	}

	public void setValorCompraProduto(BigDecimal valor_Compra_Produto) {
		this.valor_Compra_Produto = valor_Compra_Produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public NotaCompra getNotaCompra() {
		return nota_Compra;
	}

	public void setNotaCompra(NotaCompra nota_Compra) {
		this.nota_Compra = nota_Compra;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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
		NotaCompraItem other = (NotaCompraItem) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "NotaCompraItem [id=" + id + ", valor_Compra_Produto=" + valor_Compra_Produto + ", quantidade=" + quantidade
				+ "]";
	}
	
	
	
	
	
	
}
