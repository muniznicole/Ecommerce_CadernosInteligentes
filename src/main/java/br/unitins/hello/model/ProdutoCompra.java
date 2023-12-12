package br.unitins.hello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProdutoCompra extends DefaultEntity{
    @ManyToOne
    @JoinColumn(name="id_Produto")
    private Produto produtoCompra;

    @Column
    private Integer quantidade;

    public Produto getProdutoCompra() {
        return produtoCompra;
    }

    public void setProdutoCompra(Produto produtoCompra) {
        this.produtoCompra = produtoCompra;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    

}
