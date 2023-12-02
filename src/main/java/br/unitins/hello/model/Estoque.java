package br.unitins.hello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;

@Entity
public class Estoque extends DefaultEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_item", unique = true)
    private Item item;
    
    @Column
    private String descricaoEstoque; 

    @Column
    private int quantidade; // Quantidade disponível em estoque
    
    public String getDescricaoEstoque() {
        return descricaoEstoque;
    }

    public void setDescricaoEstoque(String descricaoEstoque) {
        this.descricaoEstoque = descricaoEstoque;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
