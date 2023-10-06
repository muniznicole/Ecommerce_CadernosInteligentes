package br.unitins.hello.model;


public enum PerfilTipo  {
    CLIENTE(0,"Cliente"),
    ADMIN(1,"Administrador");

    private final int status;
    private final String descricao;

    PerfilTipo(int valor,String descricao){
        this.status = valor;
        this.descricao = descricao;
    }

    public int getStatus(){
        return status;
    }
    public String getDescricao() {
        return descricao;
    }
    public static PerfilTipo fromId(int id) {
        for (PerfilTipo status : PerfilTipo.values()) {
            if (status.status == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("ID de StatusPedido inválido: " + id);
    }
}
