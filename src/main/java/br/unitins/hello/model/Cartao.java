package br.unitins.hello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Cartao extends DefaultEntity {
    @Column(length = 60)
    private String titularCartao;
    
  @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cartao")
    private Tipocartao tipoCartao;
    @Column
    private Double numeroCartao;

    public String getTitularCartao() {
        return titularCartao;
    }
    public void setTitularCartao(String titularCartao) {
        this.titularCartao = titularCartao;
    }
    public Double getNumeroCartao() {
        return numeroCartao;
    }
    public void setNumeroCartao(Double numeroCartao) {
        this.numeroCartao = numeroCartao;
    }
    public Tipocartao getTipoCartao() {
        return tipoCartao;
    }
    public void setTipoCartao(Tipocartao tipoCartao) {
        this.tipoCartao = tipoCartao;
    }
}
