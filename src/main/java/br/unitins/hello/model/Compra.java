package br.unitins.hello.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Compra extends DefaultEntity {
    
    @Column
    private LocalDate dataCompra;

    @OneToMany
    @JoinColumn(name = "id_ProdutoCompra")
    private List<ProdutoCompra> produto;

    @OneToOne
    @JoinColumn(name = "id_PagamentoCompra")
    private Pagamento pagamentoCompra;

    


    public Pagamento getPagamentoCompra() {
        return pagamentoCompra;
    }

    public void setPagamentoCompra(Pagamento pagamentoCompra) {
        this.pagamentoCompra = pagamentoCompra;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public List<ProdutoCompra> getProduto() {
        return produto;
    }

    public void setProduto(List<ProdutoCompra> produto) {
        this.produto = produto;
    }

    

    
}
