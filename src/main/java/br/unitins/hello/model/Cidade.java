package br.unitins.hello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cidade extends DefaultEntity {
    @Column(length = 60)
    private String nomeCidade;
    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estadoCidade;

    public String getNomeCidade() {
        return nomeCidade;
    }
    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }
    public Estado getEstadoCidade() {
        return estadoCidade;
    }
    public void setEstadoCidade(Estado estadoCidade) {
        this.estadoCidade = estadoCidade;
    }

}
