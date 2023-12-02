package br.unitins.hello.dto;

import br.unitins.hello.model.TamanhoTipo;
import jakarta.validation.constraints.NotBlank;

public record ItemDTO(
    
    @NotBlank(message = "O campo nomeItem não pode ser nulo.")
    String nomeItem,

    String descricaoItem,

    @NotBlank(message = "O campo precoItem não pode ser nulo.")
    Double precoItem,

    @NotBlank(message = "O campo tamanho_tipo não pode ser nulo.")
    TamanhoTipo tamanho_tipo,
    
    String imagemItem

) {}