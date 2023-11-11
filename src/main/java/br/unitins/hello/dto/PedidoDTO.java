package br.unitins.hello.dto;

import jakarta.validation.constraints.NotBlank;

public record PedidoDTO (
    @NotBlank(message = "O campo item não pode ser nulo.")
    Long item,
    @NotBlank(message = "O campo usuario não pode ser nulo.")
    Long usuario,
    @NotBlank(message = "O campo preco não pode ser nulo.")
    Double preco
    
){
    
}
    