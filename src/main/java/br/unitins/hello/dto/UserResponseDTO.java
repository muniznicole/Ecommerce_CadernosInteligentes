package br.unitins.hello.dto;

import br.unitins.hello.model.Usuario;

public record UserResponseDTO(
        String nomeuser,
        String login,
        String telefone,
        Long id,
        String perfil

) {
    public UserResponseDTO(Usuario usuario) {
        this(
                usuario.getNomeCompleto(),
                usuario.getLogin(),
                usuario.getTelefone(),
                usuario.getId(),
                usuario.getPerfil().getDescricao());
    }
}
