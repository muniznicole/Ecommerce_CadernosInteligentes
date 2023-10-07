package br.unitins.hello.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

@Entity
public class Estoque extends DefaultEntity {
    
    @Column
    private String descricaoEstoque; 

    @Column
    private int quantidade; // Quantidade disponível em estoque

    @OneToMany
    @JoinTable(name="item_estoque",
        joinColumns= @JoinColumn(name="id_estoque"),
        inverseJoinColumns = @JoinColumn(name="id_item") )
    private List<Item> itemList;

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

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

}
