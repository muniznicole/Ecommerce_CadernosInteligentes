package br.unitins.hello.dto;

import br.unitins.hello.model.Usuario;

public record UserResponseDTO(
     String nomeuser,
    String login,
    String telefone
) {

    public static UserResponseDTO valueOf(Usuario usuario){

        return new UserResponseDTO( 
            usuario.getNomeCompleto(),
            usuario.getLogin(),
            usuario.getTelefone()
        );
    }


}
