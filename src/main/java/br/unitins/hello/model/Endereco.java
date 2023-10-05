package br.unitins.hello.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Endereco extends DefaultEntity {
    @Column(length = 60)
    private String endereco;
    @Column(length = 60)
    private String complemento;
    @Column
    private Integer numero;
    @Column(length = 60)
    private String cep;
      @OneToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidadeEnderco;
}
