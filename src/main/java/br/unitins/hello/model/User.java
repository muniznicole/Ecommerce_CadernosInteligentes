package br.unitins.hello.model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class User extends DefaultEntity{
     @Column(length = 60)
    private String nomeCompleto;
    @Column(length = 60)
    private String cpf;
    @Column(length = 60)
    private String telefone;
    @Column(length = 60)
    private String email;
    @Column(length = 60)
    private String senha;
    @Column(length = 60)
    private String enderecoUser;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_perfil")
    private PerfilTipo perfilUser;
    @ManyToMany
    @Column(name = "id_cartao")
    private Cartao cartaoUser;
}
