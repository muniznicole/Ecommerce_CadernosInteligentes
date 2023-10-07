package br.unitins.hello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Estoque extends DefaultEntity {

    @ManyToOne
    @JoinColumn(name = "id_item") // Chave estrangeira para o item
    private Item item; // Referência para o item

    @Column
    private int quantidade; // Quantidade disponível em estoque

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
