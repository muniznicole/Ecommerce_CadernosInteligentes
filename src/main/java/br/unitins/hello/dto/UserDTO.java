package br.unitins.hello.dto;

import br.unitins.hello.model.PerfilTipo;

public record UserDTO(
        String nomeCompleto,
        String login,
        String telefone,
        String cpf,
        String email,
        String senha,
        PerfilTipo perfil
) {

}
