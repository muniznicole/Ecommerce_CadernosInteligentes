package br.unitins.hello.model;

import jakarta.persistence.Entity;

@Entity
public class Item extends DefaultEntity {

    public enum TamanhoItem {
        P,
        M,
        G
    }
    
    private String nomeItem;
    private String descricaoItem;
    private double precoItem;
    private String imagemItem;

    public String getNomeItem() {
        return nomeItem;
    }
    
    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }
    
    public String getDescricaoItem() {
        return descricaoItem;
    }
    
    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }
    
    public double getPrecoItem() {
        return precoItem;
    }
    
    public void setPrecoItem(double precoItem) {
        this.precoItem = precoItem;
    }
    
    public String getImagemItem() {
        return imagemItem;
    }
    
    public void setImagemItem(String imagemItem) {
        this.imagemItem = imagemItem;
    }

}
