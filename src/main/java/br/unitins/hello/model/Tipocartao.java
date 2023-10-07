package br.unitins.hello.model;

public enum Tipocartao {
    DEBITO (0,"Debito"),
    CREDITO (1,"Credito");

    private final int status;
    private final String descricao;

    Tipocartao(int valor,String descricao){
        this.status = valor;
        this.descricao = descricao;
    }

    public int getStatus(){
        return status;
    }
    public String getDescricao() {
        return descricao;
    }
    public static Tipocartao fromId(int id) {
        for (Tipocartao status : Tipocartao.values()) {
            if (status.status == id) {
                return status;
            }
        }
        throw new IllegalArgumentException("ID de Status inválido: " + id);
    }
}
