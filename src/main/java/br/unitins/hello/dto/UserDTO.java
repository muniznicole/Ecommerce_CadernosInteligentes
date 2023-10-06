package br.unitins.hello.dto;

import jakarta.persistence.Column;

public record UserDTO(
    String nomeCompleto,
    String login,
   String telefone
   
) {
   
}
