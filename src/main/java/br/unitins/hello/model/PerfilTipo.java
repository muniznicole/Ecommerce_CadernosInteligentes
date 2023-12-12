package br.unitins.hello.model;

import jakarta.persistence.Enumerated;

public enum PerfilTipo  {
    CLIENTE(0, "Cliente"),
    ADMIN(1, "Administrador");


    private final long status;
    private final String descricao;

    PerfilTipo(long valor, String descricao) {
        this.status = valor;
        this.descricao = descricao;
    }
    @Enumerated()
    public long getStatus() {
        return status;
    }

    public String getDescricao() {
        return descricao;
    }

    public static PerfilTipo fromId(long id) {
        for (PerfilTipo status : PerfilTipo.values()) {
            if (status.status == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("ID de Status inválido: " + id);
    }
}
