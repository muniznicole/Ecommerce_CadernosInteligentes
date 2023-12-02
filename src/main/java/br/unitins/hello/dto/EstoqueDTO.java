package br.unitins.hello.dto;

import jakarta.validation.constraints.NotBlank;

public record EstoqueDTO(
    
    @NotBlank(message = "O campo descricaoEstoque não pode ser nulo.")
    String descricaoEstoque,
    @NotBlank(message = "O campo quantidade não pode ser nulo.")
    int quantidade,
    @NotBlank(message = "O campo idItem não pode ser nulo.")
    Long idItem
    
) {}