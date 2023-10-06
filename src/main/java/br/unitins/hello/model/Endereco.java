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
      public String getEndereco() {
        return endereco;
      }
      public void setEndereco(String endereco) {
        this.endereco = endereco;
      }
      public String getComplemento() {
        return complemento;
      }
      public void setComplemento(String complemento) {
        this.complemento = complemento;
      }
      public Integer getNumero() {
        return numero;
      }
      public void setNumero(Integer numero) {
        this.numero = numero;
      }
      public String getCep() {
        return cep;
      }
      public void setCep(String cep) {
        this.cep = cep;
      }
      public Cidade getCidadeEnderco() {
        return cidadeEnderco;
      }
      public void setCidadeEnderco(Cidade cidadeEnderco) {
        this.cidadeEnderco = cidadeEnderco;
      }
}
