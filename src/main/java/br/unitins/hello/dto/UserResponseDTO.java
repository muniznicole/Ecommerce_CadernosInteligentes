package br.unitins.hello.dto;

import br.unitins.hello.model.Usuario;

public record UserResponseDTO(
        String nomeuser,
        String login,
        Long id,
        String perfil

) {
    public static UserResponseDTO valueOf(Usuario usuario){

        return new UserResponseDTO(
            usuario.getNomeCompleto(),
            usuario.getLogin(),
            usuario.getId(),
            usuario.getPerfil().getDescricao());
    }
}
