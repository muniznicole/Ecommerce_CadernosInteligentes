package br.unitins.hello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Pagamento extends DefaultEntity {
    
    @OneToOne
    @JoinColumn(name = "id_Pedido")
    private Pedido pedido;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pagamento")
    private PagamentoTipo pagamentoTipo;

    @OneToOne
    @JoinColumn(name = "id_datacompra")
    private DataCompra dataCompra;

    @Column
    private String StatusPagamento;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public PagamentoTipo getPagamentoTipo() {
        return pagamentoTipo;
    }

    public void setPagamentoTipo(PagamentoTipo pagamentoTipo) {
        this.pagamentoTipo = pagamentoTipo;
    }

    public DataCompra getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(DataCompra dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getStatusPagamento() {
        return StatusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        StatusPagamento = statusPagamento;
    }

}
