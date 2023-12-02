package br.unitins.hello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Item extends DefaultEntity {
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tamanho_tipo")
    private TamanhoTipo tamanho_tipo;

    @Column
    private String nomeItem;
    @Column
    private String descricaoItem;
    @Column
    private Double precoItem;
    @Column
    private String nomeImagemItem;

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
    
    public Double getPrecoItem() {
        return precoItem;
    }
    
    public void setPrecoItem(Double precoItem) {
        this.precoItem = precoItem;
    }
    
    

    public TamanhoTipo getTamanho_tipo() {
        return tamanho_tipo;
    }

    public void setTamanho_tipo(TamanhoTipo tamanho_tipo) {
        this.tamanho_tipo = tamanho_tipo;
    }

    public String getNomeImagemItem() {
        return nomeImagemItem;
    }

    public void setNomeImagemItem(String nomeImagemItem) {
        this.nomeImagemItem = nomeImagemItem;
    }

}
