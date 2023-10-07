package br.unitins.hello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
@Entity
public class Endereco extends DefaultEntity {
    @Column(length = 60)
    private String quadra;
    @Column(length = 60)
    private String alameda;
    @Column(length = 60)
    private String complemento;
    @Column
    private Integer numero;
    @Column(length = 60)
    private String cep;
      @OneToOne
    @JoinColumn(name = "id_cidade")
    private  Cidade cidadeEnderco;
      
      public String getQuadra() {
        return quadra;
      }
      public void setQuadra(String quadra) {
        this.quadra = quadra;
      }
      public String getAlameda() {
        return alameda;
      }
      public void setAlameda(String alameda) {
        this.alameda = alameda;
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
