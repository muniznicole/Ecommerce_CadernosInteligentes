package br.unitins.hello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Carrinho extends DefaultEntity {

    @OneToOne
    @JoinColumn(name = "id_item")
    private Item item;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column
    private double precoTotalCarrinho;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getPrecoTotalCarrinho() {
        return precoTotalCarrinho;
    }

    public void setPrecoTotalCarrinho(double precoTotalCarrinho) {
        this.precoTotalCarrinho = precoTotalCarrinho;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
