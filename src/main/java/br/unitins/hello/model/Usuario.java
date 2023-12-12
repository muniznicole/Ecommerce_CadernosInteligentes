package br.unitins.hello.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


@Entity
public class Usuario extends DefaultEntity{
    
    @Column
    private String nomeCompleto;
    @Column
    private String cpf;
    @Column
    private String login;
    @Column
    private String telefone;
    @Column
    private String email;
    @Column(unique = true)
    private String senha;

    @Enumerated(EnumType.STRING)
    private PerfilTipo perfil;

    public PerfilTipo getPerfil() {
        return perfil;
    }
    public void setPerfil(PerfilTipo perfil) {
        this.perfil = perfil;
    }
    
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getNomeCompleto() {
        return nomeCompleto;
    }
   
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
 
}
