package br.unitins.hello.dto;

import br.unitins.hello.model.Usuario;

public record UserResponseCompraDTO(
        String nomeuser,
        String telefone


) {
    public static UserResponseCompraDTO valueOf(Usuario usuario){

        return new UserResponseCompraDTO(
            usuario.getNomeCompleto(),
            usuario.getTelefone()
            );
    }
}
