package br.unitins.hello.dto;

import br.unitins.hello.model.Tipocartao;
import jakarta.validation.constraints.NotNull;

public record CartaoDTO (

    @NotNull(message = "O titular do cartão não pode ser nulo")
    String titularCartao,

    @NotNull(message = "O tipo do cartão não pode ser nulo")
    Tipocartao cartaoTipo,

    @NotNull(message = "O número do cartão não pode ser nulo")
    String numeroCartao

){}
