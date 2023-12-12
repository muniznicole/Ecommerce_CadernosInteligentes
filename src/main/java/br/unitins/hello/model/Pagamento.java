package br.unitins.hello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pagamento extends DefaultEntity{
    
    @Enumerated(EnumType.STRING)
    private PagamentoTipo pagamentoTipo;

    @ManyToOne
    @JoinColumn(name="id_cartao")
    private Cartao cartaoPagamento;

    @Column
    private String statusPagamento;

    public PagamentoTipo getPagamentoTipo() {
        return pagamentoTipo;
    }

    public void setPagamentoTipo(PagamentoTipo pagamentoTipo) {
        this.pagamentoTipo = pagamentoTipo;
    }

    public Cartao getCartaoPagamento() {
        return cartaoPagamento;
    }

    public void setCartaoPagamento(Cartao cartaoPagamento) {
        this.cartaoPagamento = cartaoPagamento;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    
}
