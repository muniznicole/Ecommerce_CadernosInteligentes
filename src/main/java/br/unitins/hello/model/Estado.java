package br.unitins.hello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
@Entity
public class Estado extends DefaultEntity{
    @Column(length = 60)
    private String nomeEstadoCompleto;
    @Column(length = 2)
    private String abreviado;
    public String getNomeEstadoCompleto() {
        return nomeEstadoCompleto;
    }
    public void setNomeEstadoCompleto(String nomeEstadoCompleto) {
        this.nomeEstadoCompleto = nomeEstadoCompleto;
    }
    public String getAbreviado() {
        return abreviado;
    }
    public void setAbreviado(String abreviado) {
        this.abreviado = abreviado;
    }
}
