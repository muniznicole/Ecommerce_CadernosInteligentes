package br.unitins.hello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido extends DefaultEntity {

    @OneToOne
    @JoinColumn(name = "id_item")
    private Item item;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column
    private double precoTotalPedido;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getPrecoTotalPedido() {
        return precoTotalPedido;
    }

    public void setPrecoTotalPedido(double precoTotalPedido) {
        this.precoTotalPedido = precoTotalPedido;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
