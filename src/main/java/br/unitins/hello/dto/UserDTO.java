package br.unitins.hello.dto;

import br.unitins.hello.model.PerfilTipo;
import jakarta.validation.constraints.NotNull;

public record UserDTO(

        @NotNull(message = "O nome não pode ser nulo")
        String nomeCompleto,
        
        @NotNull(message = "O login não pode ser nulo")
        String login,
        
        String telefone,
        
        @NotNull(message = "O CPF não pode ser nulo")
        String cpf,
        
        @NotNull(message = "O email não pode ser nulo")
        String email,
        
        @NotNull(message = "A senha não pode ser nula")
        String senha,

        @NotNull(message = "O perfil não pode ser nulo")
        PerfilTipo perfil

) {}
