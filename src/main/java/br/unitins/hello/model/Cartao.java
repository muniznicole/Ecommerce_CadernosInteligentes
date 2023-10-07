package br.unitins.hello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Cartao extends DefaultEntity {
    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Column(length = 60)
    private String titularCartao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cartao")
    private Tipocartao tipoCartao;
    @Column
    private String numeroCartao;

    public String getTitularCartao() {
        return titularCartao;
    }

    public void setTitularCartao(String titularCartao) {
        this.titularCartao = titularCartao;
    }

    public Tipocartao getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(Tipocartao tipoCartao) {
        this.tipoCartao = tipoCartao;
    }
}
