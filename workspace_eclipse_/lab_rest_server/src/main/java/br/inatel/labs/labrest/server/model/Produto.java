package br.inatel.labs.labrest.server.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Produto {
    private Long id;
    private String descricao;
    private BigDecimal preco;

    public Produto(Long id, String descricao, BigDecimal preco) {
        super();
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Produto() {
		
	}

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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return Objects.equals(getId(), produto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
